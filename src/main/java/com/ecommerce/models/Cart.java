package com.ecommerce.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ecommerce.entities.ProductEntity;
import com.ecommerce.entities.UserEntity;


@Entity
public class Cart {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	
	@OneToMany
	private List<ProductEntity> products;
	
	@OneToOne
	private UserEntity user;
	
	
	private double discount;
	private double total;
	

	public List<ProductEntity> getProducts() {
		return products;
	}
	public void setProduct(List<ProductEntity> products) {
		this.products = products;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
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
