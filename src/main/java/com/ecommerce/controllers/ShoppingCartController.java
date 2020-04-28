package com.ecommerce.controllers;

import java.util.Map;

import com.ecommerce.entities.CartEntity;
import com.ecommerce.models.Cart;
import com.ecommerce.services.ShoppingCartService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin
@RequestMapping("/cart")
public class ShoppingCartController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    Environment environment;

    // Create new cart passing in a Cart Object in the body
    // Optional query param "productId" as a product id to create cart with corresponding product as a product in cart
    // Otherwise pass the full Product Object in the Cart Object 

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> createNewCart(@RequestBody Cart cart, @RequestParam Map<String, String> queryParameters) throws Exception {
        logger.info("Creation request for cart {}", cart);
        String productId = queryParameters.get("productId");
        Cart newCart = null;
        if (productId == null) { 
            newCart = shoppingCartService.createCart(cart);
        } else {
            Integer productIdValue = Integer.valueOf(productId);
            newCart = shoppingCartService.createCart(cart, productIdValue);
        }
        logger.info(environment.getProperty("Controller.ADDED_NEW_CART"));
        return new ResponseEntity<Cart>(newCart, HttpStatus.CREATED);
    }

    // Get all carts
    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<CartEntity> getAllProducts() {
        return shoppingCartService.getAllCarts();
    }

    // Delete a product passing in id param

    @DeleteMapping(path = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteProduct(@RequestParam Integer id) {
        shoppingCartService.deleteCart(id);
        return new ResponseEntity<Object>("Success: deleted cart with id: " + id, HttpStatus.OK);
    }

    // Add product to existing cart
    // @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<Cart> createNewCart(@RequestBody Cart cart) {
    //     logger.info("Creation request for cart {}", cart);
    //     Cart newCart = shoppingCartService.createCart(cart);
    //     logger.info(environment.getProperty("Controller.ADDED_NEW_CART"));
    //     return new ResponseEntity<Cart>(newCart, HttpStatus.CREATED);
    // }

}