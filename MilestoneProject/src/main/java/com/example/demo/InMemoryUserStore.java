package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Milestone 3 (No DB yet):
 * Stores ONE user's email/password in memory.
 *
 * Later (Milestone 4), this can be replaced by a DB Repository.
 */
@Component
public class InMemoryUserStore implements UserStore {

    // Stored in memory (not a database yet)
    private String savedEmail;
    private String savedPassword;

    @Override
    public void saveUser(String email, String password) {
        this.savedEmail = email;
        this.savedPassword = password;
    }

    @Override
    public boolean isValidLogin(String email, String password) {

        // If no one registered yet, nothing to match
        if (savedEmail == null || savedPassword == null) {
            return false;
        }

        // Basic checks
        if (email == null || password == null) {
            return false;
        }

        // Trim email spaces and compare
        return savedEmail.equalsIgnoreCase(email.trim())
                && savedPassword.equals(password);
    }

    @Override
    public String getSavedEmail() {
        return savedEmail;
    }
}