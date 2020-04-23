package com.ecommerce.dao;

import com.ecommerce.models.User;

public class CommerceDAOImpl implements CommerceDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addUser(User user) throws Exception {
		
	}
	
	@Override
	public User getUser(String email, String password) throws Exception {
		return null;
	}
}
