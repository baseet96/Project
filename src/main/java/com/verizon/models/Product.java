package com.verizon.models;

public class Product {

	private String id;
	private String name;
	private String description;
	private double price;
	private double discount;
	private double deliveryCharge;
	private int inventory;
	
	
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
}
