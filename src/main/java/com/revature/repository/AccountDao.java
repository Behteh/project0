package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public Account selectAccount(int account_id) {
		System.out.println("Getting user with account_id: " + account_id);
		
		Account account = null;
		
		final String sql = "SELECT * FROM account_info WHERE account_id = "+account_id+";";
			
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();)
			{
				ResultSet set = statement.executeQuery(sql);
				
				if(set.next()) {
					account = new Account(
							set.getInt(1),
							set.getInt(2),
							set.getDouble(3));
							
						System.out.println(account);
					}
						
					} catch (SQLException e) {
						e.printStackTrace();	
					}	
			return account;
	}
	public void createAccount(int account_id, double accountnumber, double accountbalance) {
		final String sql = "Insert into account_info (account_id, accountnumber, accountbalance)"+"Values(?,?,?);";
		try {
			PreparedStatement set = con.prepareStatement(sql);
			set.setDouble(3, accountbalance);
			set.setDouble(2, accountnumber);
			set.setInt(1, account_id);
			set.executeUpdate();
			set.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Failed");
		}
		System.out.println("Account Created");
		}
	public boolean deleteUser(int account_id) {

		final String sql1 = "DELETE FROM account_info WHERE account_id = "+account_id+";";
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();){
					ResultSet set1 = statement.executeQuery(sql1);
					if(set1.next()){
						set1.getInt(1);
					}
						
					} catch (SQLException e) {
						

					}
		System.out.println("Deletion Complete.");
		return false;
	}


	public void deposit(int account_id, double accountbalance) {
		
		final String sql = "UPDATE account_info SET accountbalance = accountbalance + ? WHERE account_id = ?;";

		try {
			PreparedStatement set = con.prepareStatement(sql);
			set.setDouble(1, accountbalance);
			set.setInt(2, account_id);
			set.executeUpdate();
			set.close();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
	
		}
		System.out.println("Deposit Complete." +accountbalance);
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
		String sql2 = "UPDATE account_info SET accountbalance = accountbalance + ? WHERE account_id = ?;";
		
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
			e.printStackTrace();
			System.out.println("Failed");
		}
		
		System.out.println("Transfer complete");
	}
}
	