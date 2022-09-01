package com.revature.util;

import java.util.Scanner;

public class InputUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	public static int getIntChoice(int max) {
		int inputValue;
		
		do {
			while(!scanner.hasNextInt()) {
				scanner.nextLine();
				System.out.println("Incorrect input");
			}
						inputValue = scanner.nextInt();
			scanner.nextLine();
						if(inputValue <= 0 || inputValue > max) {
				System.out.println("Incorrect input");
			}
			
		} while(inputValue < 0 || inputValue > max);


		return inputValue;
	}
	
	public static double getDoubleInput(int max) {
		double inputValue;
		

		do {
			while(!scanner.hasNextDouble()) {
				scanner.nextLine();
				System.out.println("Incorrect input");
			}
			
			inputValue = scanner.nextDouble();
			scanner.nextLine();
			

			if(inputValue <= 0 || inputValue > max) {
				System.out.println("Incorrect input");
			}
			
		} while(inputValue < 0 || inputValue > max);

		return inputValue;
	}
	public static String getStringInput(int max) {
		String input;
		
		while(true) {
			input = scanner.nextLine();
			input = input.trim();
			return input;
		}
}
}