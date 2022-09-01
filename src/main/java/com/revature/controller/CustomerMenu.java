package com.revature.controller;

import java.util.Scanner;

import com.revature.services.AccountManagement;

public class CustomerMenu{
	
	private static Scanner sc;
	private static AccountManagement accountmanagement = new AccountManagement();

	public void menu(String[] args) {
		System.out.println("Select your desired operation \n W: Withdraw \n"
				+ " D: Deposit \n T: Transfer \n Q: Quit");
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
		}
	} while (!options.equals("Q"));
	}
}