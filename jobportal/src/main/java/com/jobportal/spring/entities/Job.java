package com.jobportal.spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Job_Id;
	
	private String Title;
	private String Description;
	private String Skill;
	private String Experience;
	private String Salary;
	private String PostingDate;
	private String State;
	private String District;
		
	private int Employer_Id;

	@Override
	public String toString() {
		return "Job [Job_Id=" + Job_Id + ", Title=" + Title + ", Description=" + Description + ", Skill=" + Skill
				+ ", Experience=" + Experience + ", Salary=" + Salary + ", PostingDate=" + PostingDate + ", State="
				+ State + ", District=" + District + ", Employer_Id=" + Employer_Id + "]";
	}

	public Job(int job_Id, String title, String description, String skill, String experience, String salary,
			String postingDate, String state, String district, int employer_Id) {
		super();
		Job_Id = job_Id;
		Title = title;
		Description = description;
		Skill = skill;
		Experience = experience;
		Salary = salary;
		PostingDate = postingDate;
		State = state;
		District = district;
		Employer_Id = employer_Id;
	}

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getJob_Id() {
		return Job_Id;
	}

	public void setJob_Id(int job_Id) {
		Job_Id = job_Id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getSkill() {
		return Skill;
	}

	public void setSkill(String skill) {
		Skill = skill;
	}

	public String getExperience() {
		return Experience;
	}

	public void setExperience(String experience) {
		Experience = experience;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public String getPostingDate() {
		return PostingDate;
	}

	public void setPostingDate(String postingDate) {
		PostingDate = postingDate;
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

	public long getEmployer_Id() {
		return Employer_Id;
	}

	public void setEmployer_Id(int employer_Id) {
		Employer_Id = employer_Id;
	}

	
	
}
