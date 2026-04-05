package com.gcu;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.data.entity.UserEntity;

/**
 * Custom implementation of UserDetailsService used by Spring Security.
 * This class loads user data from the database for authentication.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersDataService usersDataService;
    
    /**
     * Constructor that injects the UsersDataService.
     * @param usersDataService Service used to retrieve user data from the database
     */
    public CustomUserDetailsService(UsersDataService usersDataService) {
        this.usersDataService = usersDataService;
    }
    
    /**
     * Loads a user by username for authentication.
     * @param username the username entered during login
     * @return UserDetails object containing user credentials and roles
     * @throws UsernameNotFoundException if the user does not exist
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = usersDataService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return new User(
            user.getUsername(),
            user.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}