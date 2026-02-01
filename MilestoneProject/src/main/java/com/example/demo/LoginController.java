package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

/**
 * Handles login page display and login form processing.
 */
@Controller
public class LoginController {

    // Hard-coded credentials for Milestone 2 (no DB yet)
    private static final String VALID_EMAIL = "test@test.com";
    private static final String VALID_PASSWORD = "password";

    /**
     * Displays the login form.
     *
     * @param model Model used to pass data to the view.
     * @return the login page view name
     */
    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login-page";
    }

    /**
     * Processes the login form submission.
     *
     * @param form    User input from the login page.
     * @param model   Model used to pass error messages to the view.
     * @param session Session used to remember login state.
     * @return redirect to home on success, otherwise login page with error message
     */
    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginForm") LoginForm form,
                               Model model,
                               HttpSession session) {

        boolean emailOk = form.getEmail() != null && form.getEmail().trim().equalsIgnoreCase(VALID_EMAIL);
        boolean passwordOk = form.getPassword() != null && form.getPassword().equals(VALID_PASSWORD);

        if (emailOk && passwordOk) {
            // Store minimal session info (not full auth, just milestone proof)
            session.setAttribute("loggedIn", true);
            session.setAttribute("userEmail", VALID_EMAIL);

            return "redirect:/home";
        }

        model.addAttribute("loginError", "Invalid email or password. Try again.");
        return "login-page";
    }

    /**
     * Logs the user out by clearing the session.
     *
     * @param session Session to invalidate.
     * @return redirect back to login
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}