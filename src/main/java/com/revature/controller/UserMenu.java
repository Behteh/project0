package com.revature.controller;

import java.util.Scanner;

import com.revature.repository.UserDao;
import com.revature.repository.exceptions.UserNotFoundException;


public class UserMenu{
	
	private static Scanner sc;
	private static UserDao usermanagement = new UserDao();

	public void menu(String[] args) {
		System.out.println("Select your desired operation \n V: View \n C: Create\n"
				+ " D: Delete User \n Q: Quit");
		String options = null;
		sc = new Scanner(System.in);
		do {
			options = sc.nextLine();
			switch(options) {
			case "V": try {
					usermanagement.getUser(options, options);
				} catch (UserNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "C": usermanagement.createUser(null);
				break;
			case "D": usermanagement.deleteUser(null);
				break;
		}
	} while (!options.equals("Q"));
	}
}