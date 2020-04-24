package com.ecommerce.dao;

import com.ecommerce.models.User;

public interface CommerceDAO {
	public void registerUser(User user) throws Exception;
	public User loginUser(String email, String password) throws Exception;
}