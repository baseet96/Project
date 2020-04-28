package com.ecommerce.controllers;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> createNewCart(@RequestBody Cart cart) {
        logger.info("Creation request for cart {}", cart);
        Cart newCart = shoppingCartService.createCart(cart);
        logger.info(environment.getProperty("Controller.ADDED_NEW_CART"));
        return new ResponseEntity<Cart>(newCart, HttpStatus.CREATED);
    }

}