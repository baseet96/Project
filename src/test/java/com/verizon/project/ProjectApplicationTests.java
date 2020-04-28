package com.verizon.project;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.controllers.AuthController;
import com.ecommerce.controllers.ProductController;
import com.ecommerce.dao.CommerceDAO;
import com.ecommerce.models.User;
import com.ecommerce.models.UserKind;
import com.ecommerce.services.AuthService;
import com.ecommerce.services.AuthServiceImpl;


@RunWith(SpringRunner.class)
// @SpringBootTest
class ProjectApplicationTests {
	
	@Autowired
	private AuthController authController;
	
	@Autowired 
	private ProductController productController;
	
	@Mock
	CommerceDAO commerceDao;

	@InjectMocks
	AuthService authService = new AuthServiceImpl();
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	private SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 

	@Test
	public void contexLoads() throws Exception {
		assertNotNull(authController);
		assertNotNull(productController);
	}
	
	
	@Test 
	public void validLogin() throws Exception {
		String email = "customer@infosys.com";
		String password = "password";
		
		User user = new User();
		user.setEmail(email);
		user.setName("Bill Billiams");
		user.setKind(UserKind.CUSTOMER);
		user.setDob(this.ft.parse("1990-01-01"));
		
		when(commerceDao.getUser("customer@infosys.com")).thenReturn(user);
		when(commerceDao.loginUser("customer@infosys.com", "password")).thenReturn(user);
		
		User actual = authService.loginUser(email, password);
		
		assertEquals(user, actual);
	}
	
	@Test 
	public void invalidLoginCredentials() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("Service.INVALID_CREDENTIALS");
		
		String email = "customer@infosys.com";
		
		User fromDao = new User();
		fromDao.setEmail(email);
		fromDao.setName("Bill Billiams");
		fromDao.setKind(UserKind.CUSTOMER);
		fromDao.setDob(this.ft.parse("1990-01-01"));
		
		when(commerceDao.getUser("customer@infosys.com")).thenReturn(fromDao);
		when(commerceDao.loginUser("customer@infosys.com", "password")).thenReturn(fromDao);
		
		String invalidPassword = "pass";
		
		authService.loginUser(email, invalidPassword);
	}
	
	@Test 
	public void invalidLoginUsername() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("Service.USER_DOES_NOT_EXISTS");
		
		String email = "customer@infosys.com";
		String password = "password";
	
		User fromDao = new User();
		fromDao.setEmail(email);
		fromDao.setName("Bill Billiams");
		fromDao.setKind(UserKind.CUSTOMER);
		fromDao.setDob(this.ft.parse("1990-01-01"));
		
		when(commerceDao.getUser("customer@infosys.com")).thenReturn(fromDao);
		when(commerceDao.loginUser("customer@infosys.com", "password")).thenReturn(fromDao);
		
		String invalidEmail = "consumer35";
		authService.loginUser(invalidEmail, password);
	}
	
	@Test 
	public void validAdminLogin() throws Exception {
		String email = "admin@infosys.com";
		String password = "passsword";
		
		User user = new User();
		user.setEmail(email);
		user.setName("Sam Williams");
		user.setKind(UserKind.ADMIN);
		user.setDob(this.ft.parse("1990-01-01"));
		
		when(commerceDao.getUser("admin@infosys.com")).thenReturn(user);
		when(commerceDao.loginUser("admin@infosys.com", "password")).thenReturn(user);
		
		User actual = authService.loginUser(email, password);
		
		assertEquals(UserKind.ADMIN, actual.getKind());
	}
	
	@Test
	public void validCustomerLogin() throws Exception {
		String email = "customer@infosys.com";
		String password = "password";
		
		User user = new User();
		user.setEmail(email);
		user.setName("Bill Billiams");
		user.setKind(UserKind.CUSTOMER);
		user.setDob(this.ft.parse("1990-01-01"));
		
		when(commerceDao.getUser("customer@infosys.com")).thenReturn(user);
		when(commerceDao.loginUser("customer@infosys.com", "password")).thenReturn(user);
		
		User actual = authService.loginUser(email, password);
		
		assertEquals(UserKind.CUSTOMER, actual.getKind());
	}
	

	@Test 
	public void validRegistration() throws Exception {
		User user = new User();
		user.setEmail("customer@infosys.com");
		user.setName("Bill Billiams");
		user.setKind(UserKind.CUSTOMER);
		user.setDob(this.ft.parse("1990-01-01"));
		user.setPassword("password");
		
		when(commerceDao.getUser(user.getEmail())).thenReturn(user);
		
		User registration = new User();
		registration.setEmail("newcustomer@infosys.com");
		registration.setName("Joe Jogans");
		registration.setKind(UserKind.CUSTOMER);
		registration.setDob(this.ft.parse("1990-01-01"));
		registration.setPassword("password");
		
		String actual = authService.registerUser(registration);
		
		assertEquals("SUCCESS", actual);
	}
	
	@Test 
	public void invalidRegistration() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("Service.USER_ALREADY_EXISTS");
		
		User user = new User();
		user.setEmail("customer@infosys.com");
		user.setName("Bill Billiams");
		user.setKind(UserKind.CUSTOMER);
		user.setDob(this.ft.parse("1990-01-01"));
		user.setPassword("password");
		
		when(commerceDao.getUser("customer@infosys.com")).thenReturn(user);
		
		authService.registerUser(user);
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
