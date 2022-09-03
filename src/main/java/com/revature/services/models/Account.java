package com.revature.services.models;

import java.util.Objects;

public class Account {
	private int accountID;
	private double accountnumber;
	private double accountbalance;
	
	
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public double getAccountBalance() {
		return accountbalance;
	}
	public void setAccountBalance(double balance, double accountbalance) {
		this.accountbalance = accountbalance;
	}
	public double getAccountNumber() {
		return accountnumber;
	}
	public void setAccountNumber(Integer accountnumber) {
		this.accountnumber = accountnumber;
	}

	
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountbalance=" + accountbalance + ", accountnumber="
				+ accountnumber + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accountID, accountbalance, accountnumber);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accountID == other.accountID
				&& Double.doubleToLongBits(accountbalance) == Double.doubleToLongBits(other.accountbalance)
				&& accountnumber == other.accountnumber;
	}
	public Account(int accountID, double accountbalance, double accountnumber) {
		super();
		this.accountID = accountID;
		this.accountnumber = accountnumber;
		this.accountbalance = accountbalance;
		
	}


}