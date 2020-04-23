package com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.entities.ProductEntity;
import com.ecommerce.models.Product;
import com.ecommerce.repositories.ProductRepository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

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
        logger.info("Successfully added product {}", product);
    }

    // Returns list of all products
    public Iterable<ProductEntity> getAllProducts() {
        logger.info("Retrieving all products");
        return productRepository.findAll();
    }

    // Get product by id
    // returns product entity or empty object if no ids match
    public Optional<ProductEntity> getProductById(Integer id) {
        logger.info("Looking up product with id {}", id);
        return productRepository.findById(id);
    }

    // Get product by name
    public Iterable<ProductEntity> getProductByName(String name) {
        ProductEntity product = new ProductEntity();
        product.setName(name);
        Example<ProductEntity> productExample = Example.of(product);
        return productRepository.findAll(productExample);
    }

    // Get product by description
    public Iterable<ProductEntity> getProductByDescription(String description) {
        ProductEntity product = new ProductEntity();
        product.setDescription(description);
        Example<ProductEntity> productExample = Example.of(product);
        return productRepository.findAll(productExample);
    }

    // Get products by exact price
    public Iterable<ProductEntity> getProductsByPrice(Integer price) {
        return productRepository.findByPrice(price);
    }

    //Get products in price range
    public Iterable<ProductEntity> getProductsByPriceRange(Integer lowerPrice, Integer higherPrice) {
        return productRepository.findByPriceBetween(lowerPrice, higherPrice);
    }

    // Get products less than given price
    public Iterable<ProductEntity> getProductsLessThanPrice(Integer price) {
        return productRepository.findByPriceLessThan(price);
    }

    // Get products more than given price
    public Iterable<ProductEntity> getProductsGreaterThanPrice(Integer price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    // Get products where final price less than given number
    public Iterable<ProductEntity> getProductsLessThanFinalPrice(Integer price) {
        List<ProductEntity> productsMatchingCondition = new ArrayList<ProductEntity>();
        List<ProductEntity> products = productRepository.findAll();
        for (ProductEntity product : products) {
            if (product.getFinalPrice() <= price) {
                productsMatchingCondition.add(product);
            }
        }
        return productsMatchingCondition;
    }

    // Get products where final price greater than given number
    public Iterable<ProductEntity> getProductsGreaterThanFinalPrice(Integer price) {
        List<ProductEntity> productsMatchingCondition = new ArrayList<ProductEntity>();
        List<ProductEntity> products = productRepository.findAll();
        for (ProductEntity product : products) {
            if (product.getFinalPrice() >= price) {
                productsMatchingCondition.add(product);
            }
        }
        return productsMatchingCondition;
    }

    // Delete Product
    public void deleteProduct(Integer id) {
        logger.info("Deleting product with id {}", id);
        productRepository.deleteById(id);
        logger.info("Successfully deleted product with id {}", id);
    }
    
    // Update Product
    public String updateProduct(Integer id, Product product) {
        logger.info("Updating product with id {}", id);
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        if (productEntity.isPresent() == false) {
            return "No product with given id exists";
        }
        logger.info("Updtaing database entry for product with id {}", id);
        ProductEntity updatedProductEntity = product.createEntity();
        updatedProductEntity.setId(id);
        productRepository.save(updatedProductEntity);
        return "Updated product with id {}, id";
    }

}