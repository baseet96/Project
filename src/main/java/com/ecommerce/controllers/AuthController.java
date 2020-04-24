package com.ecommerce.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.models.LoginForm;
import com.ecommerce.models.Product;
import com.ecommerce.models.User;
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
	
	@PostMapping(path = "/login-user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void loginUser(@RequestBody LoginForm loginForm) {
        try {
        	logger.info("Login request for user {}", loginForm.getEmail());
			authService.loginUser(loginForm.getEmail(), loginForm.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@PostMapping(path = "/register-user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registernUser(@RequestBody User user) {
        try {
        	logger.info("Registration request for user {}", user);
			authService.registerUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
