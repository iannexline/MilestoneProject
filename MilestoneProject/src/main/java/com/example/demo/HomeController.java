package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Displays the home page after login.
 */
@Controller
public class HomeController {

    /**
     * Shows the home page. If user is not "logged in" (session flag),
     * redirects to login for Milestone 2.
     *
     * @param session current HTTP session
     * @param model   model for view
     * @return home view or redirect to login
     */
    @GetMapping({"/", "/home"})
    public String home(HttpSession session, Model model) {
        Object loggedIn = session.getAttribute("loggedIn");
        if (!(loggedIn instanceof Boolean) || !((Boolean) loggedIn)) {
            return "redirect:/login";
        }

        model.addAttribute("userEmail", session.getAttribute("userEmail"));
        return "home";
    }
}