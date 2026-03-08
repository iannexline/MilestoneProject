package com.gcu;

import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;

/**
 * This service will validate user credentials by retrieving the user from the database and compare it to the store password. 
 * Acts as the business layer between the controller and the data access layer.
 */
@Service
public class LoginService {

    private final UsersDataService usersDataService;

    // Spring injects the store bean here (DI)
    public LoginService(UsersDataService usersDataService) {
        this.usersDataService = usersDataService;
    }

    /**
     * Attempts to authenticate a user using their username and password.
     * @param username The username entered by the user
     * @param password The password entered by the user
     * @return true id the credentials are valid, false otherwise
     */
    public boolean attemptLogin(String username, String password) {
    	if (username == null || password == null) {
    		return false;
    	}
       	UserEntity user = usersDataService.findByUsername(username.trim());
       	
       	if (user == null) {
       		return false;
       	}
       	
       	return user.getPassword().trim().equals(password.trim());
    }
}