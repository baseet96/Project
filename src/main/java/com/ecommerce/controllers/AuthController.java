package com.ecommerce.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.services.AuthService;
import com.ecommerce.services.ProductService;

@Controller
@RequestMapping("/")
public class AuthController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    AuthService authService;

	@GetMapping("/registration")
	public String showRegistraionPage() {
		logger.info("In Registration Page");
		
		return "registration";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		logger.info("In Login Page");

		return "login";
	}

}
