package com.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.models.Product;

@Controller
@RequestMapping("/admin")
public class AddProductController {
	
	@GetMapping("/addProduct")
	public String showAddProduct(Model model) {
		
		System.out.println("In Add Product Page");
		
		Product product = new Product();
		
		model.addAttribute("product", product);

		
		return "addProduct";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("product") Model model) {
		
		
		
		return "/shopperHome";
	}

}
