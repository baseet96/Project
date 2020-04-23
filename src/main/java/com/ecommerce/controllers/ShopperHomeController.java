package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.services.ShopperHomeService;

@Controller
@RequestMapping("/")
public class ShopperHomeController {
	
	@Autowired
	private ShopperHomeService shopperHomeService;
	
	@GetMapping("/shopperhome")
	public String showHomePage(Model model) {
		
		System.out.println("In Shopper Home Page");
		
		model.addAttribute("products",shopperHomeService.getAllProducts());
		
		return "shopperHome";
	}
	
	
	@GetMapping("/{productId}")
	public String getProductbyId(Model model, @PathVariable("productId") String productId) {
		
		System.out.println("In Product page");
		
		model.addAttribute("product",shopperHomeService.getProductById(productId));
		
		return "product";
	}
	
}