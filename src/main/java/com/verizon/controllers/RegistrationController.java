package com.verizon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RegistrationController {

	@GetMapping("/registration")
	public String showRegistraionPage() {
		System.out.println("In Registration Page");
		
		return "registration";
	}
}
