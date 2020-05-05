package com.ecommerce.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ecommerce.entities.CartEntity;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.models.Cart;
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

    // Update total price for adding new product or updating quantity of existing product
    private double updatePrice(CartEntity cart) {
        double price = 0;
        for (ProductEntity product : cart.getProducts()) {
            Integer productId = product.getId();
            Integer quantity = cart.getQuantity().get(productId);
            price += product.getFinalPrice() * quantity;
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

    // Update product quantity
    private Map<Integer, Integer> addProductQuantity(Map<Integer, Integer> quantityMap, Integer productId,
            int quantity) {
        quantityMap.put(productId, quantity);
        return quantityMap;
    }

    // Check if product is already in cart, or if new product should be added
    private boolean checkIfProductInCart(List<ProductEntity> products, Integer productId) {
        for (ProductEntity product : products) {
            if (product.getId() == productId) {
                return true;
            }
        }
        return false;
    }

    // Create a new Cart with a product
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

    // Get cart by id
    public CartEntity getCartById(Integer id) throws Exception {
        logger.info("Retrieving info for cart with id {}", id);
        Optional<CartEntity> product = shoppingCartRepository.findById(id);
        if (product.isPresent() == false) {
            logger.info("Service.INVALID_CART_ID", " exception thrown");
            throw new Exception("Service.INVALID_CART_ID");
        }
        return product.get();
    }

    // Delete a Cart
    public void deleteCart(Integer id) {
        logger.info("Deleting cart with id {}", id);
        shoppingCartRepository.deleteById(id);
        logger.info("Successfully deleted product with id {}", id);
    }

    // Add product to an existing cart
    // And add quantity of product already in cart
    public Cart addProduct(Integer cartID, Integer productID, Integer quantity) throws Exception {
        logger.info("Adding product {} to cart {}", productID, cartID);
        Optional<CartEntity> cartEntityExists = shoppingCartRepository.findById(cartID);
        if (cartEntityExists.isPresent() == false) {
            logger.info("Service.INVALID_CART_ID", " exception thrown");
            throw new Exception("Service.INVALID_CART_ID");
        }
        CartEntity cartEntity = cartEntityExists.get();
        List<ProductEntity> currentProducts = cartEntity.getProducts();
        // Get new product to be added to cart by id
        Optional<ProductEntity> productExists = productService.getProductById(productID);
        if (productExists.isPresent() == false) {
            logger.info("Service.INVALID_PRODUCT_ID", " exception thrown");
            throw new Exception("Service.INVALID_CART_ID");
        }
        // Add new product to cart list of products
        ProductEntity product = productExists.get();
        // Check that quantity to add to cart is availible in inventory
        if (product.getQuantityInInventory() < quantity) {
            logger.info("Service.INSUFFICIENT_QUANTITY_IN_INVENTORY", " exception thrown");
            throw new Exception("Service.INSUFFICIENT_QUANTITY_IN_INVENTORY");
        }

        Map<Integer, Integer> quantityMap = cartEntity.getQuantity();

        // Check if product is already in cart
        if (checkIfProductInCart(currentProducts, productID) == false) {
            currentProducts.add(product);
            cartEntity.setProduct(currentProducts);
        }
        cartEntity.setQuantity(addProductQuantity(quantityMap, productID, quantity));
        cartEntity.setTotal(updatePrice(cartEntity));
        CartEntity updatedCartEntity = shoppingCartRepository.save(cartEntity);
        logger.info("Successfully added product {} to cart {}", productID, cartID);
        return Cart.valueOf(updatedCartEntity);
    }

}