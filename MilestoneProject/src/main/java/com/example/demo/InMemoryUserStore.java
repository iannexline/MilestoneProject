package com.example.demo;

import org.springframework.stereotype.Component;

/**
 * Milestone 3 (No DB yet):
 * Stores ONE user's email/password in memory.
 */
@Component
public class InMemoryUserStore implements UserStore {

    private String savedEmail;
    private String savedPassword;

    @Override
    public void saveUser(String email, String password) {
        this.savedEmail = (email == null) ? null : email.trim();
        this.savedPassword = password;
    }

    @Override
    public boolean isValidLogin(String email, String password) {
        if (savedEmail == null || savedPassword == null) return false;
        if (email == null || password == null) return false;

        return savedEmail.equalsIgnoreCase(email.trim())
                && savedPassword.equals(password);
    }

    @Override
    public String getSavedEmail() {
        return savedEmail;
    }
}