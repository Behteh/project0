package com.revature.services.models;

public class User {
	
	protected Integer user_id;
	
	protected String username;
	
	protected String password;
	
	protected Integer access_level;
	
	protected String firstname;
	
	protected String lastname;
	
	protected String email;
	
	protected String status;

	public User(Integer user_id, String username, String password, Integer access_level, String firstname, String lastname, String email, String status) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.access_level = access_level;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.status = status;
		
		
	}

	public Integer getuser_id() {
		return user_id;
	}

	public void setuser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getAccess_level() {
		return access_level;
	}
	public void setAccess_level(Integer access_level) {
		this.access_level = access_level;
	}
	
	public String getFirstName() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return lastname;
	}
	
	public void setLastName(String lastname) {
		this.lastname = lastname;	
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getStatus() {
		return status;	
	}
	
	public void setStatus(String status) {
		this.status=status;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", access_level="
				+ access_level + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", status=" + status + "]";
	}

	public void selectUser(int user_id) {
		// TODO Auto-generated method stub
		
	}



}