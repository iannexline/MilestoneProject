package com.example.demo;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        Object emailObj = session.getAttribute("userEmail");
        System.out.println("Home session userEmail = " + emailObj);

        if (emailObj == null) {
            return "redirect:/login";
        }

        model.addAttribute("userEmail", emailObj.toString());
        return "home";
    }
}