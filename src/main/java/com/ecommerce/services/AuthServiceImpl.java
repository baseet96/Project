package com.ecommerce.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.CommerceDAO;
import com.ecommerce.models.User;


@Service(value = "authService")
@Transactional
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private CommerceDAO commerceDAO;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public User loginUser(String email, String password) throws Exception {
		if (commerceDAO.getUser(email) == null ) {
			logger.info("Service.USER_DOES_NOT_EXISTS", " exception thrown");
			throw new Exception("Service.USER_DOES_NOT_EXISTS");
		}
		
		User user = commerceDAO.loginUser(email, password);
		
		if (user == null) {
			logger.info("Service.INVALID_CREDENTIALS", " exception thrown");
			throw new Exception("Service.INVALID_CREDENTIALS");
		}
		
		return user;
	}
	
	@Override
	public void registerUser(User user) throws Exception {
		
		if (commerceDAO.getUser(user.getEmail()) != null ) {
			logger.info("Service.USER_ALREADY_EXISTS", " exception thrown");
			throw new Exception("Service.USER_ALREADY_EXISTS");
		}
		
		commerceDAO.registerUser(user);
	}
}
