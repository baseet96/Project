package com.ecommerce.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.models.LoginForm;
import com.ecommerce.models.User;
import com.ecommerce.models.UserKind;
import com.ecommerce.services.AuthService;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    AuthService authService;
	
	@Autowired
	Environment environment;

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
	
	@PostMapping(path = "/login-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    public @ResponseBody UserKind loginUser(@RequestBody LoginForm loginForm) {
        try {
        	logger.info("Login request for user {}", loginForm.getEmail());
			User user = authService.loginUser(loginForm.getEmail(), loginForm.getPassword());
			return user.getKind();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	@PostMapping(path = "/register-user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String registernUser(@RequestBody User user) {
        try {
        	logger.info("Registration request for user {}", user);
			authService.registerUser(user);
			return environment.getProperty("Controller.REGISTRATION_SUCCESSFUL");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
    }
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}

}
