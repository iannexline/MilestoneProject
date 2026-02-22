// src/main/java/com/example/demo/RegisterController.java
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Handles registration page display and form submission.
 * Milestone 2: No database and stores user in memory.
 */
@Controller
public class RegisterController {

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

        if (!isBlank(form.getPassword())
                && !isBlank(form.getConfirmPassword())
                && !form.getPassword().equals(form.getConfirmPassword())) {
            model.addAttribute("confirmPasswordError", "Passwords must match.");
            hasErrors = true;
        }

        if (hasErrors) {
            return "register";
        }

        InMemoryUserStore.saveUser(form.getEmail(), form.getPassword());

        redirectAttributes.addFlashAttribute(
                "registerSuccess",
                "Registration successful! Now log in with: " + form.getEmail()
        );

        return "redirect:/login";
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}