package com.revature.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.revature.repository.exceptions.UserNotFoundException;
import com.revature.services.models.Account;
import com.revature.services.models.Customer;
import com.revature.services.models.User;
import com.revature.util.ConnectionFactory;

public class UserDao implements UserDaoInterface{
	
	Logger consoleLogger;
	Logger fileLogger;
	
	public UserDao() {
		consoleLogger = LoggerFactory.getLogger("consoleLogger");
		fileLogger = LoggerFactory.getLogger("fileLogger");
	}

	@Override
	public User createUser(User newUser) {
		final String sql1 = "Insert into users (users_id, username, password, access_level, firstname, lastname, email, status);"+"Values(?,?,?,?)";
		final String sql2 = "Insert into account_info (account_id, accountnumber, accountbalance);";
		User user= null;
		Account account = null;
		try (Connection connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();){
			ResultSet set1 = statement .executeQuery(sql1);
			ResultSet set2 = statement.executeQuery(sql2);
			if(set1.next()){
				user = new Customer(
						set1.getInt(1),
						set1.getString(2),
						set1.getString(3),
						set1.getInt(4),
						set1.getString(5),
						set1.getString(6),
						set1.getString(7),
						set1.getString(8));
				if(set2.next()){
				account = new Account(
						set2.getInt(1),
						set2.getInt(2),
						set2.getInt(3));
						
			}}} catch (SQLException e) {
				System.out.print(e.getMessage());
				consoleLogger.error(e.getMessage());
				fileLogger.error(e.toString());
		}
		
		return user;
	}
	

	@Override
	public User getUser(String username, String password) throws UserNotFoundException{
		consoleLogger.debug("Getting user with username: " + username);
		fileLogger.debug("Get User from Database");
		
		User user = null;
		
		final String sql = "SELECT * FROM users WHERE username = '"+username+"';";
		
		try (Connection connection = ConnectionFactory.getConnection();
			Statement statement = connection.createStatement();)
		{
			ResultSet set = statement.executeQuery(sql);
			
			if(set.next()) {
				user = new Customer(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getInt(4),
						set.getString(5),
						set.getString(6),
						set.getString(7),
						set.getString(8));
			}else {
				throw new UserNotFoundException("User not found with username: " + username);
			}
			
			
		} catch (SQLException e) {
			consoleLogger.error(e.getMessage());
			fileLogger.error(e.toString());
		}
		
		return user;
	}


	@Override
	public boolean deleteUser(User user) {

		final String sql1 = "DELETE FROM users_accounts WHERE users_id = ?;";
		final String sql2 = "DELETE FROM accounts_table WHERE account_id = ?;";
		try (Connection connection = ConnectionFactory.getConnection();
				Statement statement = connection.createStatement();){
					ResultSet set1 = statement.executeQuery(sql1);
					ResultSet set2 = statement.executeQuery(sql2);
					if(set1.next()){
						set1.getInt(1);
					}
					if(set2.next()) {
						set2.getInt(1);
					}
						
					} catch (SQLException e) {
						consoleLogger.error(e.getMessage());
						fileLogger.error(e.toString());
					}
		
		return false;
	}

	@Override
	public User updateUser(User updatedUser) {
		// TODO Auto-generated method stub
		return null;
	}
}