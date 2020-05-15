package com.verizon.project;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.List;

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
import com.ecommerce.controllers.ShoppingCartController;
import com.ecommerce.dao.CommerceDAO;
import com.ecommerce.entities.ProductEntity;
import com.ecommerce.models.Cart;
import com.ecommerce.models.Product;
import com.ecommerce.models.User;
import com.ecommerce.models.UserKind;
import com.ecommerce.repositories.ProductRepository;
import com.ecommerce.repositories.ShoppingCartRepository;
import com.ecommerce.services.AuthService;
import com.ecommerce.services.AuthServiceImpl;
import com.ecommerce.services.ProductService;
import com.ecommerce.services.ShoppingCartService;

@RunWith(SpringRunner.class)
// @SpringBootTest
class ProjectApplicationTests {

	@Autowired
	private AuthController authController;

	@Autowired
	private ProductController productController;
	
	@Autowired
	private ShoppingCartController shoppingCartController;

	@Mock
	CommerceDAO commerceDao;

	@Mock
	ProductRepository productRepository;
	
	@Mock
	ShoppingCartRepository shoppingCartRepository;

	@InjectMocks
	AuthService authService = new AuthServiceImpl();

	@InjectMocks
	ProductService productService = new ProductService();
	
	@InjectMocks
	ShoppingCartService shoppingCartService = new ShoppingCartService();

	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

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
	public void updateProduct() throws Exception {

	}

	@Test
	public void findProductById() {
		
		Product product = new Product();

		product.setDeliveryCharge(20.0);
		product.setDescription("cheapest phone");
		product.setDiscount(.05);
		product.setInventory(20);
		product.setName("Android");
		product.setPrice(500.0);
		
		ProductEntity prod = productService.createProduct(product);
		
		assertNotNull(productService.getProductById(prod.getId()));

	}

	@Test
	public void addsProduct() {
		Product product = new Product();

		product.setDeliveryCharge(20.0);
		product.setDescription("cheapest phone");
		product.setDiscount(.05);
		product.setInventory(20);
		product.setName("Android");
		product.setPrice(500.0);

		ProductEntity prod = productService.createProduct(product);
		prod.getId();

		productService.getProductById(prod.getId());

		assertEquals(productService.getProductById(prod.getId()), prod.getId());

	}

	@Test
	public void deletesProduct() throws Exception {

		Product product = new Product();

		product.setDeliveryCharge(30.0);
		product.setDescription("phone for sale");
		product.setDiscount(.10);
		product.setInventory(50);
		product.setName("Phone");
		product.setPrice(600.0);

		ProductEntity prod = productService.createProduct(product);

		productService.deleteProduct(prod.getId());

		productService.getProductById(prod.getId());

		assertNotEquals(prod, productService.getProductById(prod.getId()));
	}

	@Test
	public void getsProducts() throws Exception {
		Product product1 = new Product();

		product1.setDeliveryCharge(30.0);
		product1.setDescription("phone for sale");
		product1.setDiscount(.10);
		product1.setInventory(50);
		product1.setName("Phone");
		product1.setPrice(600.0);

		Product product2 = new Product();

		product2.setDeliveryCharge(20.0);
		product2.setDescription("cheapest phone");
		product2.setDiscount(.05);
		product2.setInventory(20);
		product2.setName("Android");
		product2.setPrice(500.0);
		
		productService.createProduct(product1);
		productService.createProduct(product2);
		
		
		Iterable<ProductEntity> products = productService.getAllProducts();
		
		assertNotNull(products);
	}
	
	@Test
	public void totalPrice() {
		Cart cart = new Cart();
		
		List<ProductEntity> products;
		
		ProductEntity product1 =  new ProductEntity();
		
		product1.setId(111);
		product1.setName("Desk");
		product1.setDescription("for office use");
		product1.setPrice(400.0);
		product1.setDiscount(0.05);
		product1.setDeliveryCharges(20.0);
		product1.setQuantityInInventory(100);
		
		ProductEntity product2 =  new ProductEntity();
		
		product2.setId(112);
		product2.setName("Chair");
		product2.setDescription("for office use");
		product2.setPrice(200.0);
		product2.setDiscount(0.10);
		product2.setDeliveryCharges(15.0);
		product2.setQuantityInInventory(100);
		
		cart.setDiscount(0);
		
		// 195 + 400
		
		
		
		double price = shoppingCartService.calculatePrice(cart);
		
		assertEquals(595, price, 0);
	}
	
	public void createCart() {
		
	}
}