package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.gcu.data.entity.ProductEntity;

/**
 * This repository extends CrudRepository and provides custom SQL queries for retrieving products from the PRODUCTS table.
 */
public interface ProductsRepository extends CrudRepository<ProductEntity, Long>{
	@Override
	@Query (value = "SELECT * FROM PRODUCTS")
	public List<ProductEntity> findAll();
	
	/**
	 * Finds products by name
	 * @param name The name to search for
	 * @return the matching product if found, othwerwise null
	 */
	@Query (value = "SELECT * FROM PRODUCTS WHERE NAME = :name")
	public ProductEntity findByName(@Param("name")String name);
	
	/**
	 * Finds a product by ID
	 * @param id the product ID
	 * @return the matching product if found, otherwise null
	 */
	@Query (value = "SELECT * FROM PRODUCTS WHERE ID = :id")
	public ProductEntity findById(@Param("id")int id);
}
