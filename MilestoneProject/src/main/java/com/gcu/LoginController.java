package com.gcu;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Login controller (web layer)
 * Uses LoginService bean (business layer).
 */
@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model,
                               @RequestParam(value = "registered", required = false) String registered) {

        // Make sure the form always exists
        if (!model.containsAttribute("loginForm")) {
            model.addAttribute("loginForm", new LoginForm());
        }

        // Optional: show success message after register redirect
        if (registered != null) {
            model.addAttribute("registerSuccess", "Registration successful! Please log in.");
        }

        return "login-page";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") LoginForm form,
                               HttpSession session,
                               Model model) {

        boolean success = loginService.attemptLogin(
        		form.getUsername(), form.getPassword()
        );

        if (success) {
            session.setAttribute("loggedIn", true);              
            session.setAttribute("username", form.getUsername().trim());
            return "redirect:/home";
        }

        model.addAttribute("loginError", "Invalid username or password");
        return "login-page";
    }

}