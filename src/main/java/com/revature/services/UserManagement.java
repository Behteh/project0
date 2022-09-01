package com.revature.services;

import com.revature.repository.AccountDao;
import com.revature.repository.exceptions.UserNotFoundException;
import com.revature.services.models.Account;
import com.revature.services.models.User;
import com.revature.util.InputUtility;
import com.revature.repository.UserDao;

public interface UserManagement {
	
	static User user = new User(null, null, null, null, null, null, null, null);
	static UserDao userdao = new UserDao();
	
	User login(String username, String password) throws UserNotFoundException;
	
	public static void createUser() {
		System.out.print("Create account selected.");
		
		System.out.println("Enter your last name.");
		user.setLastName(InputUtility.getStringInput(30));
	
		System.out.println("Enter your email.");
		user.setEmail(InputUtility.getStringInput(30));

		System.out.print("Enter your password.");
		user.setPassword(InputUtility.getStringInput(30));
	}
	
	public static void deleteUser() {
	System.out.print("Delete account.");
	int account_id = InputUtility.getIntChoice(10);
	userdao.deleteUser(null);
	}
}
