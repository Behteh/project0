package com.revature;

import java.util.Scanner;
import com.revature.controller.UserController;
import com.revature.repository.UserDao;
import com.revature.repository.UserDaoInterface;
import com.revature.repository.exceptions.UserNotFoundException;
import com.revature.services.LoginService;
import com.revature.services.models.User;

public class Driver {
	
	public static void main(String[] args) throws UserNotFoundException {
		
		
		UserDaoInterface uDao = new UserDao();
		LoginService loginService = new LoginService(uDao);
		UserController userController = new UserController(new Scanner(System.in), loginService, null);
		

		userController.login();
		
	}

}