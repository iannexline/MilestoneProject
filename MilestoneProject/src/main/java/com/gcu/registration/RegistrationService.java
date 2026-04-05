package com.gcu.registration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;

/**
 * Registration "business service"
 * Encrypts the password using BCrypt before saving the user into the database.
 */
@Service
public class RegistrationService {

    private final UsersDataService usersDataService;
    private final BCryptPasswordEncoder passwordEncoder;

    public RegistrationService(UsersDataService usersDataService) {
        this.usersDataService = usersDataService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Registers a user into the database with an encrypted password.
     */
    public boolean registerUser(String firstName, String lastName, String username, String email, String password) {

        // Check if email already exists
        if (usersDataService.findByEmail(email) != null) {
            return false;
        }

        // Check if username already exists
        if (usersDataService.findByUsername(username) != null) {
            return false;
        }

        // Encrypt the password before saving
        String encryptedPassword = passwordEncoder.encode(password);

        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(encryptedPassword);

        return usersDataService.create(user);
    }
}