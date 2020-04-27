package com.ecommerce.dao;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ecommerce.entities.UserEntity;
import com.ecommerce.models.User;

@Repository(value = "commerceDao")
public class CommerceDAOImpl implements CommerceDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void registerUser(User user) {
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
	public User loginUser(String email, String password)  {
		// TODO: Check encrypted password here.
		User user = null;
		
		UserEntity userEntity = entityManager.find(UserEntity.class, email);
		
		if ((userEntity != null) && (userEntity.getPassword() == password)) {
			user = new User();
			user.setDob(userEntity.getDob());
			user.setEmail(userEntity.getEmail());
			user.setKind(userEntity.getKind());
			user.setName(userEntity.getName());
		}
		
		return user;
	}
	
	@Override
	public User getUser(String email)  {
		// TODO: Check encrypted password here.
		User user = null;
		
		UserEntity userEntity = entityManager.find(UserEntity.class, email);
		
		if ((userEntity != null)) {
			user = new User();
			user.setDob(userEntity.getDob());
			user.setEmail(userEntity.getEmail());
			user.setKind(userEntity.getKind());
			user.setName(userEntity.getName());
		}
		
		return user;
	}
}
