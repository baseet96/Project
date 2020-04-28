package com.verizon.project;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.controllers.AuthController;
import com.ecommerce.controllers.ProductController;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	private AuthController authController;
	
	@Autowired 
	private ProductController productController;

	@Test
	public void contexLoads() throws Exception {
		assertNotNull(authController);
		assertNotNull(productController);
	}
	
	@Test 
	public void registersUser() throws Exception {
		
	}
	
	@Test 
	public void logsUserIn() throws Exception {
		
	}
	
	@Test 
	public void loginAdmin() throws Exception {
		
	}
	
	@Test
	public void loginCustomer() throws Exception {
		
	}
	
	@Test
	public void getsUser() throws Exception {
		
	}
	
	@Test
	public void modifiesProduct() throws Exception {
		
	}
	
	@Test
	public void addsProduct() throws Exception {
		
	}
	
	@Test
	public void deletesProduct() throws Exception {
		
	}
	
	@Test
	public void getsProducts() throws Exception {
		
	}
}
