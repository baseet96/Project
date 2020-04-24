package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.services.AdminHomeService;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	
	@Autowired
	private AdminHomeService adminHomeService;
	
	@GetMapping("/home")
	public String showHomePage() {
		
		System.out.println("In Admin Home Page");

		
		return "adminHome";
	}

}