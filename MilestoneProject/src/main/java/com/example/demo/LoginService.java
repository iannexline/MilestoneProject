package com.example.demo;

import org.springframework.stereotype.Service;

/**
 * Login "business service"
 * Milestone 3: checks the in-memory store.
 */
@Service
public class LoginService {

    private final UserStore userStore;

    // Spring injects the store bean here (DI)
    public LoginService(UserStore userStore) {
        this.userStore = userStore;
    }

    /**
     * Returns true if credentials match the stored user.
     */
    public boolean attemptLogin(String email, String password) {
        return userStore.isValidLogin(email, password);
    }
}