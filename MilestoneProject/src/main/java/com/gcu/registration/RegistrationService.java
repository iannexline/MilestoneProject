package com.gcu.registration;

import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(PasswordEncoder passwordEncoder, UsersDataService usersDataService) {
        this.usersDataService = usersDataService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a user into the database with an encrypted password.
     */
    public boolean registerUser(String firstName, String lastName, String username, String email, String password) {

        if (usersDataService.findByEmail(email) != null) {
            return false;
        }

        if (usersDataService.findByUsername(username) != null) {
            return false;
        }

        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        return usersDataService.create(user);
    }
}