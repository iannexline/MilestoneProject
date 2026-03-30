package com.gcu.business;

import java.util.List;

import com.gcu.model.UserModel;

/**
 * This interface represents the business layer responsible for user management. It defines methods used to retrieve and manage user information in the system.
 */
public interface UsersBusinessInterface {

	public void test();
	/**
	 * Retrieves all users from the system.
	 * @return a list of UserModel objects
	 */
	public List<UserModel> getUsers();
	
	public void init();
	
	public void destroy();
	
}
