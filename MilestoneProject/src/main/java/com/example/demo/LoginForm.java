package com.example.demo;

/**
 * Holds login form data.
 * Used by LoginController and login-page.html
 */
public class LoginForm {

    private String username;
    private String password;

    // Empty constructor
    public LoginForm() {
    }

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}