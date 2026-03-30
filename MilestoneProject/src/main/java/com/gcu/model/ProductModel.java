package com.gcu.model;

/**
 * This class is used to transfer product data from the business layer to the web layer without exposing database specific details.
 */
public class ProductModel {

    private Long id;
    private String name;
    private String description;
    private double price;
    private Long quantity;
    
    public ProductModel() {
    	
    }
    
	public ProductModel(Long id, String name, String description, double price, Long quantity) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
 
    
	
    
}
