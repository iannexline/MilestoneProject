package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles registration page display and registration form processing.
 */
@Controller
public class RegisterController {

    /**
     * Displays the registration form.
     *
     * @param model Model used to pass data to the view.
     * @return the register page view name
     */
    @GetMapping("/register")
    public String showRegister(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register-page";
    }

    /**
     * Processes the registration form submission.
     *
     * @param form  User input from the registration page.
     * @param model Model used to pass messages to the view.
     * @return login page on success, otherwise register page with error message
     */
    @PostMapping("/register")
    public String processRegister(@ModelAttribute("registerForm") RegisterForm form,
                                  Model model) {

        // Basic validation: check no fields are empty
        if (form.getFirstName() == null || form.getFirstName().trim().isEmpty() ||
            form.getLastName()  == null || form.getLastName().trim().isEmpty()  ||
            form.getEmail()     == null || form.getEmail().trim().isEmpty()     ||
            form.getPassword()  == null || form.getPassword().trim().isEmpty()) {

            model.addAttribute("registerError", "All fields are required.");
            return "register-page";
        }

        // Check passwords match
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            model.addAttribute("registerError", "Passwords do not match.");
            return "register-page";
        }

        // Registration successful — redirect to login with success message
        // (No DB yet, just milestone proof)
        return "redirect:/login?registered=true";
    }
}