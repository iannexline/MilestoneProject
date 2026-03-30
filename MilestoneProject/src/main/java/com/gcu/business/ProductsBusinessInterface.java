package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductModel;

/**
 * This interface represents the business layer for product management. It defines the operations that the application can perform on products, like retrieving, creating, updating, and deleting products. 
 */
public interface ProductsBusinessInterface {

	public void test();
	/**
	 * Retrieves all products in the system
	 * @return a list of ProductModel objects representing the available products
	 */
	public List<ProductModel> getProducts();
	
	public void init();
	
	public void destroy();
	
}
