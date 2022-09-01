package com.revature.repository.DTO;

import java.util.Objects;

public class UserDTO {
	
	protected Integer user_id;
	
	protected String username;
	
	protected String password;
	
	protected Integer access_level;
	
	protected String firstname;
	
	protected String lastname;
	
	protected String email;
	
	protected String status;

	public UserDTO(Integer user_id, String username, String password, Integer access_level, String firstname, String lastname, String email, String status) {
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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
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
	public int hashCode() {
		return Objects.hash(access_level, email, firstname, lastname, password, status, user_id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(access_level, other.access_level) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(password, other.password) && Objects.equals(status, other.status)
				&& Objects.equals(user_id, other.user_id) && Objects.equals(username, other.username);
	}


}