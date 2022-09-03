package com.revature.controller;

import java.util.Scanner;

import com.revature.services.AccountManagement;
import com.revature.services.UserManagement;

public class AdminMenu {
	
	private static Scanner sc;
	private static AccountManagement accountmanagement = new AccountManagement();
	private static UserManagement usermanagement = new UserManagement();
	
	public void menu() {
		System.out.println("Select your desired operation \n W: Withdraw	D: Deposit	T: Transfer \n"
				+ "VU: View User		VA: View Account \n"
				+ "CU: Creaute User	CA: Create Account \n"
				+ "RU: Delete User		RA: Delete Account \n"
				+ "UP: Update Pending	 \n 		Q: Quit");
		String options = null;
		sc = new Scanner(System.in);
		do {
			options = sc.nextLine();
			switch(options) {
			case "W": accountmanagement.withdraw();
				break;
			case "D": accountmanagement.deposit();
				break;
			case "T": accountmanagement.transfer();
				break;
			case "VU": usermanagement.selectUser();
				break;
			case "VA":accountmanagement.selectAccount();
				break;
			case "CU": usermanagement.createUser();
				break;
			case "RU": usermanagement.deleteUser();
				break;
			case "CA":accountmanagement.createAccount();
				break;
			case "RA":accountmanagement.deleteAccount();
				break;
			case"UP": usermanagement.updateUser();
				break;

		}
	} while (!options.equals("Q"));
	}
}
