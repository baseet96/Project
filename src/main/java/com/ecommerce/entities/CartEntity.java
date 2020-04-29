package com.ecommerce.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToMany(targetEntity = ProductEntity.class)
    private List<ProductEntity> products = new ArrayList<ProductEntity>();
    @OneToOne(optional = false)
    private UserEntity user;
    private double discount;
    private double total;
    // Maps product ids to current quantity in cart
    @ElementCollection
    @MapKeyColumn(name = "PRODUCT_ID")
    @Column(name = "PRODUCT_QUANTITY")
    @CollectionTable(name = "CART_PRODUCT_QUANTITY_MAPPING")
    private Map<Integer, Integer> quantity = new HashMap<Integer, Integer>();

    public Integer getId() {
        return id;
    }

    public void setCartId(Integer id) {
        this.id = id;
    }

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

    public Map<Integer, Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Map<Integer, Integer> quantity) {
        this.quantity = quantity;
    }
}
