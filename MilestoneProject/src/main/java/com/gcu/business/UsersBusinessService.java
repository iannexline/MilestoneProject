package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;
import com.gcu.model.UserModel;

@Service
public class UsersBusinessService implements UsersBusinessInterface{
	
	@Autowired
	UsersRepository service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	
	public void registerUser(UserModel userModel) 
	{
	    UserEntity user = new UserEntity();

	    user.setFirstName(userModel.getFirstName());
	    user.setLastName(userModel.getLastName());
	    user.setUsername(userModel.getUsername());
	    user.setEmail(userModel.getEmail());

	    // 🔥 Encrypt password HERE
	    user.setPassword(passwordEncoder.encode(userModel.getPassword()));

	    service.save(user); // since you're using repository directly
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
