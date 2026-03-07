package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;
import com.gcu.model.UserModel;

public class UsersBusinessService implements UsersBusinessInterface{
	
	@Autowired
	UsersRepository service;
	
	@Override
	public void test() {
		System.out.println("Hello from the UsersBusinessService");
	}
	
	@Override
	public List<UserModel> getUsers(){
		var usersDomain = new ArrayList<UserModel>();
		var usersEntity = service.findAll();
		
		for(UserEntity entity : usersEntity) {
			usersDomain.add(new UserModel(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getUsername(), entity.getEmail(), entity.getPassword()));
		}
		
		return usersDomain;
	}
	
	@Override
	public void init() {
		System.out.println("init method from UsersBusinessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method from UsersBusinessService");
	}

}
