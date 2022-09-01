package com.revature.services.models;

public class Customer extends User{

	public Customer(Integer userId, String username, String password, Integer access_level, String firstname, String lastname, String email, String status) {
		super(userId, username, password, access_level, firstname, lastname, email, status);
	}
}