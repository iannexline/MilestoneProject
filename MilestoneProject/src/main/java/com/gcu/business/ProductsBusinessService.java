package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductsRepository;
import com.gcu.model.ProductModel;

public class ProductsBusinessService implements ProductsBusinessInterface{
	
	@Autowired
	ProductsRepository service;
	
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
	
	@Override
	public void init() {
		System.out.println("init method from ProductsBusinessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method from ProductsBusinessService");
	}

}
