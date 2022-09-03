package com.revature.controller;

import java.util.Scanner;

import com.revature.services.AccountManagement;
import com.revature.services.UserManagement;


public class EmployeeMenu{
	
	private static Scanner sc;
	private static AccountManagement accountmanagement = new AccountManagement();
	private static UserManagement usermanagement = new UserManagement();
	
	public void menu() {
		System.out.println("Select your desired operation \n VU: View User Information \n VA: View Account Information \n AD: Approve/Deny accounts \n CA: Create approved account \n UP: Update Pending"
				+ " Q: Quit");
		String options = null;
		sc = new Scanner(System.in);
		do {
			options = sc.nextLine();
			switch(options) {
			case "VU": usermanagement.selectUser();
				break;
			case "VA":accountmanagement.selectAccount();
				break;
			case "CA":accountmanagement.createAccount();
				break;
			case"UP": usermanagement.updateUser();
			break;
			
			

		}
	} while (!options.equals("Q"));
	}
}