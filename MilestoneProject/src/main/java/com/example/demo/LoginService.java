package com.example.demo;

import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;

/**
 * Login "business service"
 * Milestone 3: checks the in-memory store.
 */
@Service
public class LoginService {

    private final UsersDataService usersDataService;

    // Spring injects the store bean here (DI)
    public LoginService(UsersDataService usersDataService) {
        this.usersDataService = usersDataService;
    }

    /**
     * Returns true if credentials match the stored user.
     */
    public boolean attemptLogin(String username, String password) {
       	UserEntity user = usersDataService.findByUsername(username);
       	
       	if (user == null) {
       		return false;
       	}
       	
       	return user.getPassword().equals(password);
    }
}