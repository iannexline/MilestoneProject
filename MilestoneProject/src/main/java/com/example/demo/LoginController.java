package com.example.demo;

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

    // Spring injects the LoginService bean
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login-page";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") LoginForm form,
                               HttpSession session,
                               Model model) {

        // Bean-based login check
        boolean ok = loginService.attemptLogin(form.getEmail(), form.getPassword());

        if (ok) {
            session.setAttribute("userEmail", form.getEmail().trim());
            return "redirect:/home";
        }

        model.addAttribute("loginError", "Invalid email or password");
        return "login-page";
    }
}