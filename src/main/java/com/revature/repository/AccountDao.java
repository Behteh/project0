package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.services.models.Account;
import com.revature.util.ConnectionFactory;


public class AccountDao {

		
	Connection con;
	public AccountDao() {
		try {
			this.con=ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}

	public Account getAccountBalance(Integer accountbalance) {
		return null;
	}

	public void deposit(int account_id, double newtbalance) {
		
		final String sql = "UPDATE account_info SET accountbalance = accountbalance + ? WHERE account_id = ?;";
		
		try {
			PreparedStatement set = con.prepareStatement(sql);
			set.setDouble(2, newtbalance);
			set.setInt(1, account_id);
			set.executeUpdate();
			set.close();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
	
		}
		System.out.println("Deposit Complete.");
			}
	
	public void withdraw(int account_id, double accountbalance) {
	
		String sql = "UPDATE account_info SET accountbalance = accountbalance - ? WHERE account_id = ?;";
		
		try {
			PreparedStatement set = con.prepareStatement(sql);
			set.setDouble(1, accountbalance);
			set.setInt(2, account_id);
			set.executeUpdate();
			set.close();
			
		}catch(SQLException e) {
			System.out.println("Failed");
		}
		System.out.println("Withdrawl complete");
	}

	public void transferMoney(int account_id1, int account_id2, double accountbalance) {
	
		String sql1 = "UPDATE account_info SET accountbalance = accountbalance - ? WHERE account_id = ?;";
		String sql2 = "UPDATE account_into SET accountbalance = accountbalance + ? WHERE account_id = ?;";
		
		try {
			PreparedStatement set1 = con.prepareStatement(sql1);
			set1.setDouble(1, accountbalance);
			set1.setInt(2, account_id1);
			set1.executeUpdate();
			set1.close();
			
			PreparedStatement set2 = con.prepareStatement(sql2);
			set2.setDouble(1, accountbalance);
			set2.setInt(2, account_id2);
			set2.executeUpdate();
			set2.close();
			
		}catch(SQLException e) {
			System.out.println("Failed");
		}
		
		System.out.println("Transfer complete");
	
	}
}
