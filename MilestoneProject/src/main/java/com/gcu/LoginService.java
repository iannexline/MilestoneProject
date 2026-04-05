package com.gcu;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;

/**
 * This service validates user credentials by retrieving the user from the
 * database and comparing the entered password against the stored BCrypt hash.
 * Acts as the business layer between the controller and the data access layer.
 */
@Service
public class LoginService {

    private final UsersDataService usersDataService;
    private final BCryptPasswordEncoder passwordEncoder;

    // Spring injects the store bean here (DI)
    public LoginService(UsersDataService usersDataService) {
        this.usersDataService = usersDataService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Attempts to authenticate a user using their username and password.
     * Uses BCrypt to compare the entered password against the stored hash.
     *
     * @param username The username entered by the user
     * @param password The password entered by the user
     * @return true if the credentials are valid, false otherwise
     */
    public boolean attemptLogin(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        UserEntity user = usersDataService.findByUsername(username.trim());

        if (user == null) {
            return false;
        }

        // Compare entered password against the stored BCrypt hash
        return passwordEncoder.matches(password.trim(), user.getPassword().trim());
    }
}