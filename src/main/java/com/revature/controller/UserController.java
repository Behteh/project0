package com.revature.controller;

import java.util.Scanner;
import com.revature.repository.exceptions.UserNotFoundException;
import com.revature.services.LoginService;
import com.revature.services.models.User;


public class UserController implements UserInputInterface, LoginInterface{
	
	private Scanner sc;
	private LoginService loginService;
	MainMenu menu = new MainMenu();

	
	public UserController(Scanner sc, LoginService loginService, MainMenu mainmenu) {
		super();
		this.sc=sc;
		this.loginService=loginService;
	}
	@Override
	public User validateLogin(String username, String password) {
		
		if(username == null && password == null) {
			return null;
		}
		
		User user = null;
		try {
			user = loginService.login(username, password);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	@Override
	public String getUserInput() {
		return sc.nextLine();
		
	}
	@Override
	public void login() {
		System.out.println("Enter username and password to login \n");
		String username = getUserInput();
		String password = getUserInput();
		User user = validateLogin(username, password);
		
		if(user != null) {
			
			System.out.println("Success");
			System.out.println(user);
			menu.menu(null);
		}else {
			System.out.println("Fail");
	}
	}
	

}
