package com.example.demo;

import org.springframework.stereotype.Service;

/**
 * Registration "business service"
 * Milestone 3: just saves the user using the store bean.
 */
@Service
public class RegistrationService {

    private final UserStore userStore;

    // Spring injects the bean automatically (DI)
    public RegistrationService(UserStore userStore) {
        this.userStore = userStore;
    }

    /**
     * "Registers" a user (Milestone 3)
     * Later you will save to DB.
     */
    public void registerUser(String email, String password) {
        userStore.saveUser(email, password);
    }
}