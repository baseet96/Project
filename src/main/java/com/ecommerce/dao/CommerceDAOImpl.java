package com.ecommerce.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ecommerce.entities.UserEntity;
import com.ecommerce.models.User;

public class CommerceDAOImpl implements CommerceDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void registerUser(User user) throws Exception {
		// TODO: Encrypt password before saving here.
		UserEntity userEntity = new UserEntity();
		userEntity.setDob(user.getDob());
		userEntity.setEmail(user.getEmail());
		userEntity.setKind(user.getKind());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		
		entityManager.persist(userEntity);
	}
	
	@Override
	public User loginUser(String email, String password) throws Exception {
		// TODO: Check encrypted password here.
		User user = null;
		
		UserEntity userEntity = entityManager.find(UserEntity.class, email);
		
		if (userEntity != null) {
			if (userEntity.getPassword() == password) {
				user = new User();
				user.setDob(userEntity.getDob());
				user.setEmail(userEntity.getEmail());
				user.setKind(userEntity.getKind());
				user.setName(userEntity.getName());
			} else {
				throw new Exception("DAO.INCORRECT_CREDENTIALS");
			}
		} else {
			throw new Exception("DAO.INCORRECT_CREDENTIALS");
		}
		
		return user;
	}
}
