package com.gcu.business;

import java.util.List;

import com.gcu.model.UserModel;

public interface UsersBusinessInterface {

	public void test();
	
	public List<UserModel> getUsers();
	
	public void init();
	
	public void destroy();
	
}
