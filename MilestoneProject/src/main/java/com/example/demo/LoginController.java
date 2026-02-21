package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles login for Milestone 2 using in-memory stored user.
 */
@Controller
public class LoginController {

    /**
     * Displays the login page.
     *
     * @param model model for Thymeleaf
     * @return login view
     */
    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login-page";
    }

    /**
     * Processes the login form submission.
     *
     * @param form user input
     * @param model model for error messages
     * @param session session for storing login state
     * @return redirect to home on success, otherwise show login with error
     */
    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") LoginForm form, HttpSession session, Model model) {

        boolean ok = InMemoryUserStore.isValidLogin(form.getEmail(), form.getPassword());
        System.out.println("Login ok? " + ok);

        if (ok) {
            session.setAttribute("userEmail", form.getEmail().trim());
            System.out.println("Session userEmail set to: " + session.getAttribute("userEmail"));
            return "redirect:/home";
        }

        model.addAttribute("loginError", "Invalid email or password");
        return "login-page";
    }
  }
