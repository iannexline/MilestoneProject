package com.example.demo;

/**
 * Holds login form data.
 * Used by LoginController and login-page.html
 */
public class LoginForm {

    private String email;
    private String password;

    // Empty constructor
    public LoginForm() {
    }

    // Getters and Setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}