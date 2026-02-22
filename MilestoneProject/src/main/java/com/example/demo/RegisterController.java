package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Registration controller (web layer)
 * Uses RegistrationService bean (business layer).
 */
@Controller
public class RegisterController {

    private final RegistrationService registrationService;

    public RegisterController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute("registerForm") RegisterForm form,
                                  Model model,
                                  RedirectAttributes redirectAttributes) {

        boolean hasErrors = false;

        if (isBlank(form.getFirstName())) {
            model.addAttribute("firstNameError", "First name is required.");
            hasErrors = true;
        }
        if (isBlank(form.getLastName())) {
            model.addAttribute("lastNameError", "Last name is required.");
            hasErrors = true;
        }
        if (isBlank(form.getEmail())) {
            model.addAttribute("emailError", "Email is required.");
            hasErrors = true;
        }
        if (isBlank(form.getPassword())) {
            model.addAttribute("passwordError", "Password is required.");
            hasErrors = true;
        }
        if (isBlank(form.getConfirmPassword())) {
            model.addAttribute("confirmPasswordError", "Confirm password is required.");
            hasErrors = true;
        }

        // Password match check (only if both entered)
        if (!isBlank(form.getPassword()) && !isBlank(form.getConfirmPassword())
                && !form.getPassword().equals(form.getConfirmPassword())) {
            model.addAttribute("confirmPasswordError", "Passwords must match.");
            hasErrors = true;
        }

        if (hasErrors) {
            return "register";
        }

        // Bean-based registration
        registrationService.registerUser(form.getEmail(), form.getPassword());

        // Show success message on login page after redirect
        redirectAttributes.addFlashAttribute(
                "registerSuccess",
                "Registration successful! Now log in with: " + form.getEmail().trim()
        );

        return "redirect:/login";
        
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}