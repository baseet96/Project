package com.ecommerce.services;

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
	
	@Override
	public User loginUser(String email, String password) throws Exception {
		User user = commerceDAO.loginUser(email, password);
		return user;
	}
	
	@Override
	public void registerUser(User user) throws Exception {
		commerceDAO.registerUser(user);
	}
}
