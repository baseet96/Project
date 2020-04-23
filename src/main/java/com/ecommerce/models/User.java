package com.ecommerce.models;

import java.util.Date;

public class User {
	
	
	private String email;
	private UserKind kind;
	private String name;
	private Date dob;
	private String password;
	
	public User() {

	}
	
	public User(String name, String email, String password, UserKind kind, Date dob) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.kind = kind;
		this.dob = dob;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public UserKind getKind() {
		return kind;
	}


	public void setKind(UserKind kind) {
		this.kind = kind;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
