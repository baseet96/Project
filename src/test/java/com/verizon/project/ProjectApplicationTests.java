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
	
	@Autowired ProductController productController;

	@Test
	public void contexLoads() throws Exception {
		assertNotNull(authController);
		assertNotNull(productController);
	}

}
