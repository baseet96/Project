package com.ecommerce.repositories;

import java.util.List;

import com.ecommerce.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findByPrice(Integer price);

    List<ProductEntity> findByPriceBetween(Integer lowerPrice, Integer higherPrice);

    List<ProductEntity> findByPriceLessThan(Integer price);

    List<ProductEntity> findByPriceGreaterThan(Integer price);

    List<ProductEntity> findByQuantityInInventoryGreaterThan(Integer quantity);

}