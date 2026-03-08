package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import com.gcu.data.entity.UserEntity;
/**
 * This repository extends CrudRepository and provides custom SQL queries for retrieving users by ID, username, and email.
 */
public interface UsersRepository extends CrudRepository<UserEntity, Long>{
	
	@Override
	@Query (value = "SELECT * FROM USERS")
	public List<UserEntity> findAll();
	
	/**
	 * Finds a user by username.
	 * @param username The username to search for
	 * @return the matching user if found, otherwise null
	 */
	@Query (value = "SELECT * FROM USERS WHERE USERNAME = :username")
	public UserEntity findByUsername(@Param("username")String username);
	
	/**
	 * Finds a user by email.
	 * @param email The email to search for
	 * @return the matching user if found, otherwise null
	 */
	@Query (value = "SELECT * FROM USERS WHERE EMAIL = :email")
	public UserEntity findByEmail(@Param("email") String email);
	
	/**
	 * Finds a user by id.
	 * @param id The id to search for
	 * @return the matching user if found, otherwise null
	 */
	@Query (value = "SELECT * FROM USERS WHERE ID = :id")
	public UserEntity findById(@Param("id")int id);
}
