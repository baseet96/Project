package com.verizon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.verizon.services.HomeService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/home")
	public String showHomePage(Model model) {
		
		System.out.println("In Home Page");
		
		model.addAttribute("products",homeService.getAllProducts());
		
		return "home";
	}
	
	
	@GetMapping("/{productId}")
	public String getProductbyId(Model model, @PathVariable("productId") String productId) {
		
		System.out.println("In Product page");
		
		model.addAttribute("product",homeService.getProductById(productId));
		
		return "product";
	}
	
}