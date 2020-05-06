package com.ecommerce.controllers;

import com.ecommerce.services.ProductService;

import com.ecommerce.entities.ProductEntity;
import com.ecommerce.models.Product;
import com.ecommerce.exceptions.MissingParamException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600,
	allowedHeaders={"x-auth-token", "x-requested-with", "x-xsrf-token"})
@RequestMapping(path = "/products")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProductService productService;

    // Create a new Product
    // POST request. Expects JSON in POST body as follows:
    // {
    //     name: String - REQUIRED
    //     description: String
    //     price: double - REQUIRED
    //     disocunt: double
    //     deliveryCharge: double - REQUIRED
    //     inventory: int - REQUIRED
    // }
    
    // Returns 201 Created and JSON of creted entity on success
    // Returns 400 and error message if parameters are missing

    @PostMapping(path = "/add-product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductEntity> addNewProduct(@RequestBody Product product) {
        if (product.getName() == null || product.getPrice() == null || product.getDeliveryCharge() == null || product.getInventory() == null) {
            throw new MissingParamException("name");
        }
        logger.info("Creation request for product {}", product);
        ProductEntity newProduct = productService.createProduct(product);
        return new ResponseEntity<ProductEntity>(newProduct, HttpStatus.CREATED);
    }

    // Get All products

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    // Delete a product passing in id param

    @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteProduct(@RequestParam Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<Object>("Success: deleted product with id: " + id , HttpStatus.OK);
    }

    // Modify a product passing in id param

    @PutMapping(path = "/put", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> modifyProduct(@RequestParam Integer id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<Object>("Success: modified product with id: " + id, HttpStatus.OK);
    }

}