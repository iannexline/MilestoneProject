package com.example.demo;

/**
 * Represents the login form fields entered by the user.
 */
public class LoginForm {

    private String email;
    private String password;

    /**
     * Gets the email address.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password.
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}