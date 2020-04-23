package com.ecommerce.controllers;

import com.ecommerce.services.ProductService;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.models.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService productService;

    // Create a new Product

    @PostMapping(path = "/add-product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewProduct(@RequestBody Product product) {
        logger.info("Creation request for product {}", product);
        productService.createProduct(product);
    }

    // Get All products

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    // Delete a product passing in id param

    @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProduct(@RequestParam Integer id) {
        productService.deleteProduct(id);
    }

    // Modify a product passing in id param

    @PutMapping(path = "/put", produces = MediaType.APPLICATION_JSON_VALUE)
    public String modifyProduct(@RequestParam Integer id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }


}