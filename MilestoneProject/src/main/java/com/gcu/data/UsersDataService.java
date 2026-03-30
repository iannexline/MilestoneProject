package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

/**
 * Implements the DataAccessInterface and uses Spring JDBC along with the UsersRepository to interact with the MySQL database.
 */
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
		return usersRepository.findById(id);
	}

	/**
	 * Finds a user using their username
	 * @param username The username used to search for a user
	 * @return The matching UserEntity if found, otherwise null
	 */
	public UserEntity findByUsername(String username) {
		 return usersRepository.findByUsername(username);
	}
	
	public UserEntity findByEmail(String email) {
		 return usersRepository.findByEmail(email);
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
		String sql = "UPDATE USERS SET FIRST_NAME = ?, LAST_NAME = ?, USERNAME = ?, EMAIL = ?, PASSWORD = ? WHERE ID = ?";
		try {
			int rows = jdbcTemplateObject.update(sql,
					user.getFirstName(),
					user.getLastName(),
					user.getUsername(),
					user.getEmail(),
					user.getPassword(),
					user.getId());
			return rows == 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		String sql = "DELETE FROM USERS WHERE ID = ?";
		try {
			int rows = jdbcTemplateObject.update(sql, id);
			return rows == 1 ? true : false;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
