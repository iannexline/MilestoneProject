package com.gcu.business;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ProductsDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

/**
 * This class retrieves product data from the data layer and converts ProductEntity objects into ProductModel objects for use by the presentation layer
 */
@Service
public class ProductsBusinessService implements ProductsBusinessInterface{
	
	@Autowired
	ProductsDataService service;
	
	@Override
	public void test() {
		System.out.println("Hello from the ProductsBusinessService");
	}
	

	@Override
	public List<ProductModel> getProducts(){
		var productsDomain = new ArrayList<ProductModel>();
		var productsEntity = service.findAll();
		
		for(ProductEntity entity : productsEntity) {
			productsDomain.add(new ProductModel(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getQuantity()));
		}
		
		return productsDomain;
	}
	
	/**
	 * Creates a new product in the system.
	 *
	 * This method converts a ProductModel object from the presentation layer
	 * into a ProductEntity object for the data layer, then saves it
	 * to the database.
	 *
	 * @param product the product model containing the new product information
	 * @return true if the product was successfully created, otherwise false
	 */
	public boolean createProduct(ProductModel product) {
	    ProductEntity entity = new ProductEntity();

	    entity.setName(product.getName());
	    entity.setDescription(product.getDescription());
	    entity.setPrice(product.getPrice());
	    entity.setQuantity(product.getQuantity());

	    return service.create(entity);
	}

	@Override
	public void init() {
		System.out.println("init method from ProductsBusinessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method from ProductsBusinessService");
	}

}
