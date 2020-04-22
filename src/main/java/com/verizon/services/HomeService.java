package com.verizon.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.verizon.models.Product;

@Service
public class HomeService {

	public List<Product> getAllProducts() {
		
		List<Product> listOfProducts = new ArrayList<>();
		listOfProducts.add(new Product("123", "IPHONE X", "This is Awesome Iphone ", 400.4, 0, 20.0, 50));
		listOfProducts.add(new Product("124", "Samsung Y", "This is Awesome Samsung ", 300.4, 0, 20.0, 50));
		listOfProducts.add(new Product("125", "LG Z", "This is Awesome LG ", 200.4, 0, 20.0, 50));

		return listOfProducts;
	}

	public Product getProductById(String id) {

		Predicate<Product> byId = p -> p.getId().equals(id);
		return filterProducts(byId);
	}

	public Product filterProducts(Predicate<Product> strategy) {
		return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
	}
}
