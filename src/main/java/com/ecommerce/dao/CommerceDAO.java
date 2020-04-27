package com.ecommerce.dao;

import com.ecommerce.models.User;

public interface CommerceDAO {
	public void registerUser(User user);
	public User loginUser(String email, String password);
	public User getUser(String email);
}