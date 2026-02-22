package com.example.demo;

/**
 *  Simple interface that can be later replaced for future milestones.
 */
public interface UserStore {

    // Save user info (Milestone 3: just store in memory)
    void saveUser(String email, String password);

    // Check if the login matches the saved user
    boolean isValidLogin(String email, String password);

    // Helpful for debugging
    String getSavedEmail();
}