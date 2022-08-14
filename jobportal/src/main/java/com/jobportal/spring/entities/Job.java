package com.jobportal.spring.entities;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int jobId;
	
	private String title;
	@Lob
	private String description;
	private String skill;
	private String experience;
	private String salary;
	private String postingDate;
	private String state;
	private String district;
	
	@ManyToOne
	private Employer employer;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<JobSeeker> jobSeeker;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(int jobId, String title, String description, String skill, String experience, String salary,
			String postingDate, String state, String district, Employer employer, List<JobSeeker> jobSeeker) {
		super();
		this.jobId = jobId;
		this.title = title;
		this.description = description;
		this.skill = skill;
		this.experience = experience;
		this.salary = salary;
		this.postingDate = postingDate;
		this.state = state;
		this.district = district;
		this.employer = employer;
		this.jobSeeker = jobSeeker;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", title=" + title + ", description=" + description + ", skill=" + skill
				+ ", experience=" + experience + ", salary=" + salary + ", postingDate=" + postingDate + ", state="
				+ state + ", district=" + district + ", employer=" + employer + ", jobSeeker=" + jobSeeker + "]";
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public List<JobSeeker> getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(List<JobSeeker> jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
	
	
	
	
}
