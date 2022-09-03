package com.revature.controller;

import java.util.Scanner;

import com.revature.repository.UserDao;
import com.revature.repository.UserDaoInterface;
import com.revature.services.LoginService;
import com.revature.services.UserManagement;

public class LoginMenu {
	
	private static Scanner sc;
	private static UserManagement usermanagement = new UserManagement();
	UserDaoInterface uDao = new UserDao();
	LoginService loginService = new LoginService(uDao);
	UserController userController = new UserController(new Scanner(System.in), loginService);
	

	
	
	public void menu(String[] args) {
		System.out.println("Select your desired operation \n L: Login \n C: Create Account \n"
				+ " Q: Quit");
		String options = null;
		sc = new Scanner(System.in);
		do {
			options = sc.nextLine();
			switch(options) {
			case "L": userController.login();
				break;
			case "C": usermanagement.createUser();
				break;
		}
	} while (!options.equals("Q"));

}
}
