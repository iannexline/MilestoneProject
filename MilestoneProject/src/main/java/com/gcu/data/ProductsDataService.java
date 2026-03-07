package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.ProductsRepository;

@Service
public class ProductsDataService implements DataAccessInterface<ProductEntity>{
	
	@Autowired
	ProductsRepository productsRepository;
	
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public ProductsDataService(ProductsRepository productsRepository, DataSource dataSource) {
		this.productsRepository = productsRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public List<ProductEntity> findAll() {

List<ProductEntity> products = new ArrayList<ProductEntity>();
		
		try {
			Iterable<ProductEntity> productsIterable = productsRepository.findAll();
			products = new ArrayList<ProductEntity>();
			productsIterable.forEach(products::add);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public ProductEntity findById(int id) {
		return null;
	}

	public ProductEntity findByName(String name) {
		 return productsRepository.findByName(name);
	}

	
	public boolean create(ProductEntity product) {
		String sql = "INSERT INTO PRODUCTS(NAME, DESCRIPTION, PRICE, QUANTITY) VALUES (?, ?, ?, ?)";
		try {
			int rows = jdbcTemplateObject.update(sql,
					product.getName(),
					product.getDescription(),
					product.getPrice(),
					product.getQuantity());
			return rows ==1 ? true : false; 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(ProductEntity product) {
		return true;
	}

	public boolean delete(ProductEntity product) {
		return true;
	}

}
