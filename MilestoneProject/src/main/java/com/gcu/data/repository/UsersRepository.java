package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import com.gcu.data.entity.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long>{
	
	@Override
	@Query (value = "SELECT * FROM USERS")
	public List<UserEntity> findAll();
	
	
	@Query (value = "SELECT * FROM USERS WHERE USERNAME = :username")
	public UserEntity findByUsername(@Param("username")String username);
	
	@Query (value = "SELECT * FROM USERS WHERE EMAIL = :email")
	public UserEntity findByEmail(@Param("email") String email);
	
	@Query (value = "SELECT * FROM USERS WHERE ID = :id")
	public UserEntity findById(@Param("id")int id);
}
