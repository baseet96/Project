//package com.ecommerce.models;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//
//import com.ecommerce.entities.ProductEntity;
//
//
//@Entity
//public class Cart {
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer cartId;
//	
//	
//	private ProductEntity product;
//	
//	
//	private double discount;
//	private double total;
//	
//
//	public ProductEntity getProduct() {
//		return product;
//	}
//	public void setProduct(ProductEntity product) {
//		this.product = product;
//	}
//	public double getDiscount() {
//		return discount;
//	}
//	public void setDiscount(double discount) {
//		this.discount = discount;
//	}
//	public double getTotal() {
//		return total;
//	}
//	public void setTotal(double total) {
//		this.total = total;
//	}
//}
