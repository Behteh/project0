package com.revature.repository;

import com.revature.repository.exceptions.UserNotFoundException;
import com.revature.services.models.User;

public interface UserDaoInterface {
	
	public User createUser(User newUser);
	
	public User getUser(String username, String password) throws UserNotFoundException;

	User updateUser(User updatedUser);

	boolean deleteUser(User user);	

}
