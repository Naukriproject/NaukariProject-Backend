package com.jobportal.spring.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Employee_Id;
	private String First_Name;
	private String Last_Name;
	private String Mobile;
	private String Email;
	private String Password;
	private String Gender;
	private int Age;
	private String Experience;
	private String Skill;
	private String State;
	private String District;
	private boolean Active;
	
		
	public Employee(int employee_Id, String first_Name, String last_Name, String mobile, String email, String password,
			String gender, int age, String experience, String skill, String state, String district, boolean active) {
		super();
		Employee_Id = employee_Id;
		First_Name = first_Name;
		Last_Name = last_Name;
		Mobile = mobile;
		Email = email;
		Password = password;
		Gender = gender;
		Age = age;
		Experience = experience;
		Skill = skill;
		State = state;
		District = district;
		Active = active;
	}
	@Override
	public String toString() {
		return "Employee [Employee_Id=" + Employee_Id + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name
				+ ", Mobile=" + Mobile + ", Email=" + Email + ", Password=" + Password + ", Gender=" + Gender + ", Age="
				+ Age + ", Experience=" + Experience + ", Skill=" + Skill + ", State=" + State + ", District="
				+ District + ", Active=" + Active + "]";
	}
	public int getEmployee_Id() {
		return Employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
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
	public void setPasaword(String password) {
		Password = password;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getExperience() {
		return Experience;
	}
	public void setExperience(String experience) {
		Experience = experience;
	}
	public String getSkill() {
		return Skill;
	}
	public void setSkill(String skill) {
		Skill = skill;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public boolean isActive() {
		return Active;
	}
	public void setActive(boolean active) {
		Active = active;
	}
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
