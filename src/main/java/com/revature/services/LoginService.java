package com.revature.services;

import com.revature.services.models.User;
import com.revature.repository.UserDaoInterface;
import com.revature.repository.exceptions.UserNotFoundException;


public class LoginService {
	
	private UserDaoInterface userDao;

	public LoginService(UserDaoInterface userDao) {
		super();
		this.userDao=userDao;
	}
	public User login(String username, String password) throws UserNotFoundException {
		return userDao.getUser(username, password);
		
		}

	public boolean logout() {
		return false;
	}
	public void deleteUser() {

	}

	public boolean updateUser(User updatedUser) {
		return false;
	}
	public void createUser() {
		// TODO Auto-generated method stub
		
	}
}
