package com.gcu;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  This controller invalidates the current HTTP session when a user logs out of the application.
 *  Invalidating the session removes any stored login information and ensures that the user must log in again to access protected pages.
 */
@Controller
public class LogoutController {

	/**
	 * This method invalidates the current HTTP session and redirects the user back to the login page.
	 * @param session The current HTTP session containing user login data
	 * @return redirect to the login page
	 */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}