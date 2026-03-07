package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UsersDataService implements DataAccessInterface<UserEntity>{
	
	@Autowired
	UsersRepository usersRepository;
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public UsersDataService(UsersRepository usersRepository, DataSource dataSource) {
		this.usersRepository = usersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<UserEntity> findAll() {

		List<UserEntity> users = new ArrayList<UserEntity>();
		
		try {
			Iterable<UserEntity> usersIterable = usersRepository.findAll();
			users = new ArrayList<UserEntity>();
			usersIterable.forEach(users::add);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public UserEntity findById(int id) {
		return null;
	}

	public UserEntity findByUsername(String username) {
		 return usersRepository.findByUsername(username);
	}

	
	public boolean create(UserEntity user) {
		String sql = "INSERT INTO USERS(FIRST_NAME, LAST_NAME, USERNAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?)";
		try {
			int rows = jdbcTemplateObject.update(sql,
					user.getFirstName(),
					user.getLastName(),
					user.getUsername(),
					user.getEmail(),
					user.getPassword());
			return rows ==1 ? true : false; 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(UserEntity user) {
		return true;
	}

	public boolean delete(UserEntity user) {
		return true;
	}

}
