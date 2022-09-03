package com.revature.repository;

import com.revature.repository.exceptions.UserNotFoundException;
import com.revature.services.models.User;

public interface UserDaoInterface {
	
	
	public User getUser(String username, String password) throws UserNotFoundException;

	
	public User selectUser(int user_id) throws UserNotFoundException;

	User createUser(int user_id, String username, String password, int access_level, String firstname,
			String lastname, String email, String status);

	boolean deleteUser(int user_id);

	User updateUser(int user_id, String status);	

}
