package com.gcu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests related to the login page.
 * Displays login form and handles messages for registration, errors, and logout.
 */
@Controller
public class LoginController {

    /**
     * Displays the login page and handles optional query parameters for messages.
     * @param model Model object used to pass data to the view
     * @param registered Indicates if the user has just registered successfully
     * @param error Indicates if there was a login error
     * @param logout Indicates if the user has logged out
     * @return the login page view name
     */
    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(value = "registered", required = false) String registered,
                                @RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "logout", required = false) String logout) {

        if (!model.containsAttribute("loginForm")) {
            model.addAttribute("loginForm", new LoginForm());
        }

        if (registered != null) {
            model.addAttribute("registerSuccess", "Registration successful! Please log in.");
        }

        if (error != null) {
            model.addAttribute("loginError", "Invalid username or password.");
        }

        if (logout != null) {
            model.addAttribute("logoutMessage", "You have been logged out.");
        }

        return "login-page";
    }
}