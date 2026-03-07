package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.gcu.data.entity.ProductEntity;

public interface ProductsRepository extends CrudRepository<ProductEntity, Long>{
	
	@Override
	@Query (value = "SELECT * FROM PRODUCTS")
	public List<ProductEntity> findAll();
	
	
	@Query (value = "SELECT * FROM PRODUCTS WHERE NAME = :name")
	public ProductEntity findByName(@Param("name")String name);
	
	@Query (value = "SELECT * FROM PRODUCTS WHERE ID = :id")
	public ProductEntity findById(@Param("id")int id);
}
