package com.ecommerce.dao;

import com.ecommerce.models.User;

public interface CommerceDAO {
	public void addUser(User user) throws Exception;
	public User getUser(String email, String password) throws Exception;
}