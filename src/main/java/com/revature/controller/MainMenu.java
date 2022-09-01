package com.revature.controller;

import java.util.Scanner;

public class MainMenu {
	
	private static Scanner sc;
	private static UserMenu umenu = new UserMenu();
	private static CustomerMenu cmenu = new CustomerMenu();
	
	public void menu(String[] args) {
		System.out.println("Select your desired operation \n U: User Menu \n A: Account Menu \n"
				+ " Q: Quit");
		String options = null;
		sc = new Scanner(System.in);
		do {
			options = sc.nextLine();
			switch(options) {
			case "U": umenu.menu(args);
				break;
			case "A": cmenu.menu(args);
				break;
		}
	} while (!options.equals("Q"));
	}
}
