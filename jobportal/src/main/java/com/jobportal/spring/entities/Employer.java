package com.jobportal.spring.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Employer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employerId;
	
	private String name;
	private String company;
	private String address;
	private String mobile;
	private String email;
	private String password;
	private String roles;
	private boolean active;
	
	@OneToMany(mappedBy = "employer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Job> jobs;

	@Override
	public String toString() {
		return "Employer [employerId=" + employerId + ", name=" + name + ", company=" + company + ", address=" + address
				+ ", mobile=" + mobile + ", email=" + email + ", password=" + password + ", roles=" + roles
				+ ", active=" + active + ", jobs=" + jobs + "]";
	}

	public Employer(int employerId, String name, String company, String address, String mobile, String email,
			String password, String roles, boolean active, List<Job> jobs) {
		super();
		this.employerId = employerId;
		this.name = name;
		this.company = company;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.active = active;
		this.jobs = jobs;
	}

	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployerId() {
		return employerId;
	}

	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	
	
	
	
	
}
