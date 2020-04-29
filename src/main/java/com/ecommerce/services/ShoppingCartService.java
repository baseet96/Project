package com.ecommerce.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    ProductService productService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // Calculate total price
    private double calculatePrice(Cart cart) {
        double price = 0;
        for (ProductEntity product : cart.getProducts()) {
            price += product.getFinalPrice();
        }
        if (cart.getDiscount() == 0) {
            return price;
        }
        return price - (price * cart.getDiscount());
    }

    // Set product quantity
    private Map<Integer, Integer> setQuantity(Integer productId, int quantity) {
        Map<Integer, Integer> quantityMap = new HashMap<Integer, Integer>();
        quantityMap.put(productId, quantity);
        return quantityMap;
    }

    // Create a new Cart with products
    // Assumes quantity of product is 1
    public Cart createCart(Cart cart) throws Exception {
        logger.info("Creating database entry for cart {}", cart);
        cart.setTotal(calculatePrice(cart));
        CartEntity cartEntity = cart.createEntity();
        ProductEntity product = cart.getProducts().get(0);
        Optional<ProductEntity> productExists = productService.getProductById(product.getId());
        // Check that product is valid
        if (productExists.isPresent() == false) {
            logger.info("Service.INVALID_PRODUCT_ID", " exception thrown");
            throw new Exception("Service.INVALID_PRODUCT_ID");
        }
        // set quantity for product
        cartEntity.setQuantity(setQuantity(product.getId(), 1));
        CartEntity newCartEntity = shoppingCartRepository.save(cartEntity);
        logger.info("Successfully added cart {}", cart);
        return Cart.valueOf(newCartEntity);
    }

    // Create a new cart with product id as a parmaeter
    // Assumes quantity of product is 1
    public Cart createCart(Cart cart, Integer productId) throws Exception {
        logger.info("Creating database entry for cart {}", cart);
        Optional<ProductEntity> productExists = productService.getProductById(productId);
        // Check that product is valid
        if (productExists.isPresent() == false) {
            logger.info("Service.INVALID_PRODUCT_ID", " exception thrown");
            throw new Exception("Service.INVALID_PRODUCT_ID");
        }
        ProductEntity productEntity = productExists.get();
        List productEntityList = new ArrayList<ProductEntity>();
        productEntityList.add(productEntity);
        cart.setProduct(productEntityList);
        cart.setTotal(calculatePrice(cart));
        CartEntity cartEntity = cart.createEntity();
        cartEntity.setQuantity(setQuantity(productEntity.getId(), 1));
        CartEntity newCartEntity = shoppingCartRepository.save(cartEntity);
        logger.info("Successfully added cart {}", cart);
        return Cart.valueOf(newCartEntity);
    }

    // Returns list of all Carts
    public Iterable<CartEntity> getAllCarts() {
        logger.info("Retrieving all Carts");
        return shoppingCartRepository.findAll();
    }

    // Delete a Cart
    public void deleteCart(Integer id) {
        logger.info("Deleting cart with id {}", id);
        shoppingCartRepository.deleteById(id);
        logger.info("Successfully deleted product with id {}", id);
    }

    // Add product to an existing cart
    // public Cart addProduct(Integer cartID, Integer productID) throws Exception {
    //     logger.info("Adding product {} to cart {}", productID, cartID);
    //     Optional<CartEntity> cartEntityExists = shoppingCartRepository.findById(cartID);
    //     if (cartEntityExists.isPresent() == false) {
    //         logger.info("Service.INVALID_CART_ID", " exception thrown");
    //         throw new Exception("Service.INVALID_CART_ID");
    //     }
    //     CartEntity cartEntity = cartEntityExists.get();
    //     List<ProductEntity> currentProducts = cartEntity.getProducts();
    //     currentProducts.add(product.createEntity());
    //     CartEntity newCartEntity = cart.createEntity();
    //     CartEntity updatedCartEntity = shoppingCartRepository.save(newCartEntity);
    //     logger.info("Successfully added product {} to cart {}", product, cart);
    //     return Cart.valueOf(updatedCartEntity);
    // }
    
}