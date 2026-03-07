package com.gcu.data.entity;

import org.springframework.data.relational.core.mapping.Table;

@Table("Products")
public class ProductEntity {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private Long quantity;
	
	
	
	public ProductEntity() {
		super();
	}



	public ProductEntity(Long id, String name, String description, Double price, Long quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public Long getQuantity() {
		return quantity;
	}



	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	
}
