package com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ecommerce.entities.CartEntity;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.models.Cart;
import com.ecommerce.models.Product;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.ShoppingCartRepository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service(value = "shoppingCartService")
@Transactional
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // Create a new Cart with products
    public Cart createCart(Cart cart) {
        logger.info("Creating database entry for cart {}", cart);
        CartEntity cartEntity = cart.createEntity();
        CartEntity newCartEntity = shoppingCartRepository.save(cartEntity);
        logger.info("Successfully added cart {}", cart);
        return Cart.valueOf(newCartEntity);
    }

    // Add product to an existing cart
    public Cart addProduct(Cart cart, Product product) throws Exception {
        logger.info("Adding product {} to cart {}", product, cart);
        Optional<CartEntity> cartEntity = shoppingCartRepository.findById(cart.getCartId());
        if (cartEntity.isPresent() == false) {
            logger.info("Service.INVALID_CART_ID", " exception thrown");
            throw new Exception("Service.INVALID_CART_ID");
        }
        List<ProductEntity> currentProducts = cart.getProducts();
        currentProducts.add(product.createEntity());
        CartEntity newCartEntity = cart.createEntity();
        CartEntity updatedCartEntity = shoppingCartRepository.save(newCartEntity);
        logger.info("Successfully added product {} to cart {}", product, cart);
        return Cart.valueOf(updatedCartEntity);
    }
    
}