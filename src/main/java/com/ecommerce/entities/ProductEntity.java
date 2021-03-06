package com.ecommerce.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private Double price;
    private Double discount;
    @NotNull
    private Double deliveryCharges;
    @NotNull
    private Integer quantityInInventory;
    @ManyToMany(targetEntity = CartEntity.class, mappedBy = "products")
    private List<CartEntity> carts = new ArrayList<CartEntity>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantityInInventory() {
        return quantityInInventory;
    }

    public void setQuantityInInventory(Integer quantityInInventory) {
        this.quantityInInventory = quantityInInventory;
    }

    public Double getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(Double deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Calculate price with disocunt
    public Double getDisocuntedPrice() {
        return this.getPrice() - (this.getPrice() * this.getDiscount());
    }

    // Calculate total price including delivery charges
    public Double getFinalPrice() {
        return this.getDisocuntedPrice() + this.getDeliveryCharges();
    }

}