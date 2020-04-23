package com.ecommerce.services;

import com.ecommerce.entities.ProductEntity;
import com.ecommerce.models.Product;
import com.ecommerce.repositories.ProductRepository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductRepository productRepository;

    // Create a new Product
    public void createProduct(Product product) {
        logger.info("Creating database entry for product {}", product);
        ProductEntity productEntity = product.createEntity();
        productRepository.save(productEntity);
    }

    // Returns list of all products
    public Iterable<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

}