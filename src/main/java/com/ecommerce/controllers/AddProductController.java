package com.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AddProductController {
	
	@GetMapping("/addProduct")
	public String showHomePage() {
		
		System.out.println("In Add Product Page");

		
		return "addProduct";
	}

}
