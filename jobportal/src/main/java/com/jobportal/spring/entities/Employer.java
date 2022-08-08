package com.jobportal.spring.entities;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Employer_Id;
	
	private String Name;
	private String Company;
	private String Address;
	private String Mobile;
	private String Email;
	private Boolean Active;
	
	@Override
	public String toString() {
		return "Employer [Employer_Id=" + Employer_Id + ", Name=" + Name + ", Company=" + Company + ", Address="
				+ Address + ", Mobile=" + Mobile + ", Email=" + Email + ", Active=" + Active + "]";
	}

	public Employer(int employer_Id, String name, String company, String address, String mobile, String email,
			Boolean active) {
		super();
		Employer_Id = employer_Id;
		Name = name;
		Company = company;
		Address = address;
		Mobile = mobile;
		Email = email;
		Active = active;
	}

	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployer_Id() {
		return Employer_Id;
	}

	public void setEmployer_Id(int employer_Id) {
		Employer_Id = employer_Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
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

	public Boolean getActive() {
		return Active;
	}

	public void setActive(Boolean active) {
		Active = active;
	}
	
	
	
}
