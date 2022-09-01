package com.revature.services;

import com.revature.repository.AccountDao;
import com.revature.services.models.Account;
import com.revature.util.InputUtility;

public class AccountManagement {
	
	private static Account account = new Account(0, 0, 0);
	private static AccountDao accountdao = new AccountDao();
	

	public double getBalance() {
		return account.getAccountBalance();
	}
	
	public void setBalance(double balance) {
		balance = account.getAccountBalance();
	}
	
	public void deposit() {
		System.out.print("Select account for deposit.");
		int account_id = InputUtility.getIntChoice(100);
		
		System.out.println();
		System.out.print("Input deposit amount.");
		double accountbalance = InputUtility.getDoubleInput(100_000);
		
		accountdao.deposit(account_id, accountbalance);
	}
	public void withdraw() {
		System.out.print("Select account for withdrawls.");
		int account_id = InputUtility.getIntChoice(100);
		System.out.println();
		System.out.print("Input withdrawl amount.");
		double balance = InputUtility.getDoubleInput(100_000);
		accountdao.withdraw(account_id, balance);
	}
	public void transfer() {
		System.out.print("Select account to transfer from.");
		int account_idFrom = InputUtility.getIntChoice(100);
		System.out.println();
		System.out.print("Select account to transfer to.");
		int account_idTo = InputUtility.getIntChoice(100);
		System.out.println();
		
		System.out.print("Input transfer amount.");
		double balance = InputUtility.getDoubleInput(100_000);
		
		accountdao.transferMoney(account_idFrom, account_idTo, balance);
	}

}
