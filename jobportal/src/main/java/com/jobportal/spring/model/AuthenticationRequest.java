package com.jobportal.spring.model;

public class AuthenticationRequest {
	
	private String username;
	
	private String password;
	
	private boolean active;
	
	private String roles;

	public AuthenticationRequest(String username, String password, boolean active, String roles) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}

	public AuthenticationRequest() {
	
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AuthenticationRequest [username=" + username + ", password=" + password + ", active=" + active
				+ ", roles=" + roles + "]";
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	

}
