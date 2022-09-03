package com.revature.services;

import com.revature.services.models.User;
import com.revature.util.InputUtility;
import com.revature.repository.UserDao;

public class UserManagement {
	
	private static User user = new User(null, null, null, null, null, null, null, null);
	static UserDao userdao = new UserDao();
	

	public void createUser() {
		System.out.print("Create account selected.");
		
		System.out.println("Enter user_id");
		int user_id = (InputUtility.getIntChoice(100));
		user.setuser_id(user_id);
		System.out.println("Enter your username.");
		String username=(InputUtility.getStringInput(30));
		user.setUsername(username);
		System.out.print("Enter your password.");
		String password=(InputUtility.getStringInput(30));
		user.setPassword(password);
		System.out.print("Enter your access_level");
		int access_level=(InputUtility.getIntChoice(100));
		user.setAccess_level(access_level);
		System.out.println("Enter your first name.");
		String firstname=(InputUtility.getStringInput(30));
		user.setFirstname(firstname);
		System.out.println("Enter your last name.");
		String lastname=(InputUtility.getStringInput(30));
		user.setLastName(lastname);
		System.out.println("Enter your email.");
		String email=(InputUtility.getStringInput(30));
		user.setEmail(email);
		user.setStatus("pending");
		userdao.createUser(user_id, username, password, access_level, firstname, lastname, email, "pending");
	}
	public void updateUser() {
		System.out.print("Update account selected.");
		
		System.out.println("Enter user_id");
		int user_id = InputUtility.getIntChoice(100);
		System.out.println(" Updated account: approved or denied ");
		String status=(InputUtility.getStringInput(30));
		user.setStatus(status);
		userdao.updateUser(user_id, status);
	}

	
	public void deleteUser() {
	System.out.print("Delete user:");
	int user_id = (InputUtility.getIntChoice(100));
	userdao.deleteUser(user_id);
	}

	public void selectUser() {
		System.out.println("Enter desired user id.");
		int user_id = (InputUtility.getIntChoice(100));
		userdao.selectUser(user_id);	
	}
}
