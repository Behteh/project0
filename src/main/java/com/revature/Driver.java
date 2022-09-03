package com.revature;

import com.revature.controller.LoginMenu;
import com.revature.repository.exceptions.UserNotFoundException;

public class Driver {
	
	public static void main(String[] args) throws UserNotFoundException {
		
		LoginMenu menu=new LoginMenu();
		
		menu.menu(args);
		
	}

}