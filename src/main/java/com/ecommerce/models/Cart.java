package com.ecommerce.models;

public class Cart {
	
	private String id;
	private Product product;
	private double discount;
	private double total;
	public Cart(String id, Product product, double discount, double total) {
		super();
		this.id = id;
		this.product = product;
		this.discount = discount;
		this.total = total;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
