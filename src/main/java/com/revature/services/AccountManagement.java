package com.revature.services;

import com.revature.repository.AccountDao;
import com.revature.services.models.Account;
import com.revature.util.InputUtility;

public class AccountManagement {
	
	private static Account account = new Account(0, 0, 0);
	private static AccountDao accountdao = new AccountDao();
	

	public void selectAccount() {
		System.out.println("Enter desired account id.");
		int account_id = (InputUtility.getIntChoice(100));
		accountdao.selectAccount(account_id);	
	}
	
	public void setBalance(double balance) {
		balance = account.getAccountBalance();
	}
	
	public void deposit() {
		System.out.print("Select account for deposit.");
		int account_id = InputUtility.getIntChoice(100);
		System.out.print("\n Input deposit amount.");
		double accountbalance = InputUtility.getDoubleInput(100_000);
		
		accountdao.deposit(account_id, accountbalance);
	}
	public void withdraw() {
		System.out.print("Select account for withdrawls.");
		int account_id = InputUtility.getIntChoice(100);
		System.out.print("\n Input withdrawl amount.");
		double accountbalance = InputUtility.getDoubleInput(100_000);
		accountdao.withdraw(account_id, accountbalance);
	}
	public void transfer() {
		System.out.print("Select account to transfer from.");
		int account_idFrom = InputUtility.getIntChoice(100);
		System.out.print("\n Select account to transfer to.");
		int account_idTo = InputUtility.getIntChoice(100);
		System.out.print("\n Input transfer amount.");
		double accountbalance = InputUtility.getDoubleInput(100_000);
		
		accountdao.transferMoney(account_idFrom, account_idTo, accountbalance);
	}
	public void createAccount() {
		System.out.print("Input account_id");
		int account_id = InputUtility.getIntChoice(100);
		System.out.print("Input accountnumber");
		double accountnumber = InputUtility.getDoubleInput(100_000);
		System.out.print("Input accountbalance");
		double accountbalance = InputUtility.getDoubleInput(100_000);
		accountdao.createAccount(account_id, accountnumber, accountbalance);
	}
	public void deleteAccount() {
	System.out.print("Delete user:");
	int account_id = (InputUtility.getIntChoice(100));
	accountdao.deleteUser(account_id);
	}

	public void updateAccount() {
		
		// TODO Auto-generated method stub
		
	}

}
