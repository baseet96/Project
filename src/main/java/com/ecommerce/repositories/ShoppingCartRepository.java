package com.ecommerce.repositories;

import com.ecommerce.entities.CartEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<CartEntity, Integer> {

}