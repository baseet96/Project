package com.ecommerce.services;

import org.springframework.stereotype.Service;

import com.ecommerce.models.User;

@Service
public interface AuthService {
	public User loginUser(String email, String password) throws Exception;
	public String registerUser(User user) throws Exception;
}
