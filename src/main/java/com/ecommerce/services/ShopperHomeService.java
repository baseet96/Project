package com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.ProductEntity;
import com.ecommerce.models.Product;
import com.ecommerce.repositories.ProductRepository;

@Service
public class ShopperHomeService {
	
	@Autowired
	ProductRepository productRepository;

	public List<ProductEntity> getAllProducts() {
		
//		List<Product> listOfProducts = new ArrayList<>();
//		listOfProducts.add(new Product("123", "IPHONE X", "This is Awesome Iphone ", 400.4, 0, 20.0, 50));
//		listOfProducts.add(new Product("124", "Samsung Y", "This is Awesome Samsung ", 300.4, 0, 20.0, 50));
//		listOfProducts.add(new Product("125", "LG Z", "This is Awesome LG ", 200.4, 0, 20.0, 50));
		
		
		List<ProductEntity> listOfProducts = new ArrayList<>();
		
		System.out.println("************");
		System.out.println(productRepository.findAll());
		Iterable<ProductEntity> products = productRepository.findAll();
		
		listOfProducts = productRepository.findAll();
		
		for (ProductEntity product: products) {
			System.out.println(product.getName());
			System.out.println(product.getDescription());
			System.out.println(product.getId());
			System.out.println(product.getDiscount());
			System.out.println(product.getPrice());
			System.out.println(product.getQuantityInInventory());
		}

		return listOfProducts;
	}

	public ProductEntity getProductById(String id) {
		
		Iterable<ProductEntity> products = productRepository.findAll();
		
		for (ProductEntity product: products) {
			if (product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}

}
