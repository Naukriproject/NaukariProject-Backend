package com.jobportal.spring.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	private int Employer_Id;
	
	private String First_Name;
	private String Last_Name;
	private String Company;
	
	@Column(length = 200)
	private String Address;
	
	private String Mobile;
	
	@Column(unique = true)
	private String Email;
	private String Password;
	private String Role;
	private Boolean Active;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employer")
	private List<Job> jobs = new ArrayList<>();
	
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Employer [Employer_Id=" + Employer_Id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name
				+ ", Company=" + Company + ", Address=" + Address + ", Mobile=" + Mobile + ", Email=" + Email
				+ ", Password=" + Password + ", Role=" + Role + ", Active=" + Active + "]";
	}

	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getEmployer_Id() {
		return Employer_Id;
	}

	public void setEmployer_Id(int employer_Id) {
		Employer_Id = employer_Id;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public Boolean getActive() {
		return Active;
	}

	public void setActive(Boolean active) {
		Active = active;
	}

	public Employer(int employer_Id, String first_Name, String last_Name, String company, String address,
			String mobile, String email, String password, String role, Boolean active) {
		super();
		Employer_Id = employer_Id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Company = company;
		Address = address;
		Mobile = mobile;
		Email = email;
		Password = password;
		Role = role;
		Active = active;
	}
	

}
