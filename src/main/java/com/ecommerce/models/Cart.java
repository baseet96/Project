package com.ecommerce.models;

import java.util.List;

import com.ecommerce.entities.CartEntity;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.entities.UserEntity;

public class Cart {
    private Integer id;
    private List<ProductEntity> products;
    private UserEntity user;
    private double discount;
    private double total;

    public Cart() {
    }

    public Cart(Integer id, List<ProductEntity> products, UserEntity user, double discount, double total) {
        super();
        this.id = id;
        this.products = products;
        this.user = user;
        this.discount = discount;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Product DTO [products=" + products + ", user=" + user + ", discount=" + discount + ", total="
                + total + "]";
    }

    // converts entity Into Model
    public static Cart valueOf(CartEntity cartEntity) {
        Cart cart = new Cart();
        cart.setId(cartEntity.getId());
        cart.setProduct(cartEntity.getProducts());
        cart.setUser(cartEntity.getUser());
        cart.setDiscount(cartEntity.getDiscount());
        cart.setTotal(cartEntity.getTotal());
        

        return cart;
    }

    // converts model Into Entity
    public CartEntity createEntity() {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setProduct(this.getProducts());
        cartEntity.setUser(this.getUser());
        cartEntity.setDiscount(this.getDiscount());
        cartEntity.setTotal(this.getTotal());

        return cartEntity;
    }
}
