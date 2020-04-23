package com.ecommerce.models;

import com.ecommerce.entities.ProductEntity;

public class Product {
	private String id;
	private String name;
	private String description;
	private double price;
	private double discount;
	private double deliveryCharge;
	private int inventory;

	public Product() {
	};

	public Product(String id, String name, String description, double price, double discount, double deliveryCharge,
			int inventory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.deliveryCharge = deliveryCharge;
		this.inventory = inventory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	//converts entity into Model
	public static Product valueOf(ProductEntity productEntity) {
		Product product = new Product();
		product.setName(productEntity.getName());
		product.setDescription(productEntity.getDescription());
		product.setPrice(productEntity.getPrice());
		product.setDiscount(productEntity.getDiscount());
		product.setDeliveryCharge(productEntity.getDeliveryCharges());
		product.setInventory(productEntity.getQuantityInInventory());

		return product;
	}

	//converts model into Entity
	public ProductEntity createEntity() {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(this.getName());
		productEntity.setDescription(this.getDescription());
		productEntity.setPrice(this.getPrice());
		productEntity.setDiscount(this.getDiscount());
		productEntity.setDeliveryCharges(this.getDeliveryCharge());
		productEntity.setQuantityInInventory(this.getInventory());

		return productEntity;
	}
}