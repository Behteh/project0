package com.revature.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.repository.exceptions.UserNotFoundException;
import com.revature.services.models.Customer;
import com.revature.services.models.User;
import com.revature.util.ConnectionFactory;

public class UserDao implements UserDaoInterface{
	
	Connection con;
	public UserDao() {
		try {
			this.con=ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private final Logger filelogger= LoggerFactory.getLogger("fileLogger");
	private final Logger consolelogger = LoggerFactory.getLogger("consoleLogger");
	

	@Override
	public User createUser(int user_id, String username, String password, int access_level,
			String firstname, String lastname, String email,String status) {
		filelogger.debug("createUser attempted with follow variables int user_id, String username, String password, int access_level,\r\n"
				+ "			String firstname, String lastname, String email,String status ");
		User user = null;
		
		final String sql = "Insert into users (user_id, username, password, access_level, firstname, lastname, email, status)"
				+ "Values(?,?,?,?,?,?,?,?);";
		
		
		try {
			PreparedStatement set = con.prepareStatement(sql);
						set.setInt(1, user_id);
						set.setString(2, username);
						set.setString(3, password);
						set.setInt(4, access_level);
						set.setString(5, firstname);
						set.setString(6, lastname);
						set.setString(7, email);
						set.setString(8, status);
						set.executeUpdate();
						set.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
	
		}
		System.out.println("Creation Complete.");
		return user;
			}


	

	public User getUser(String username, String password) throws UserNotFoundException{
		filelogger.debug("test");
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

		}
		
		return user;
	}


	@Override
	public boolean deleteUser(int user_id) {
		filelogger.debug("test");

		final String sql1 = "DELETE FROM users WHERE user_id = "+user_id+";";
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

	public User updateUser(int user_id, String status) {
		filelogger.debug("test");
		
		final String sql = "UPDATE users SET status = ? Where user_id = ?;";		
		
		try {
			PreparedStatement set = con.prepareStatement(sql);
						set.setString(1, status);
						set.setInt(2, user_id);
						set.executeUpdate();
						set.close();
						
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
	
		}
		System.out.println("Status Update Complete.");
		return null;
	}
	public User selectUser(int user_id) {
		
		filelogger.debug("test");
		System.out.println("Getting user with user_id: " + user_id);
		
		User user = null;
		
		final String sql = "SELECT * FROM users WHERE user_id = "+user_id+";";
			
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
						System.out.println(user);
					}
						
					} catch (SQLException e) {
						e.printStackTrace();	
					}	
			return user;
	}
}