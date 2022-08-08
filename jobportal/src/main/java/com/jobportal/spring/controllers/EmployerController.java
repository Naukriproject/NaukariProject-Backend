package com.jobportal.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.Job;
import com.jobportal.spring.services.EmployerService;
import com.jobportal.spring.services.JobService;



@RestController
@RequestMapping("/employer")
public class EmployerController {

	@Autowired
	private JobService jobService;
	
	@Autowired
	private EmployerService employerService;
	
	// Get All Employees
	@GetMapping("/employer")
	public List<Employer> getAllEmployer()
	{
		return this.employerService.getEmployer();
		
	}
	
	// Employer Registration
	@PostMapping("/employer")
	public Employer employerRegistration(@RequestBody Employer employer)
	{
		Employer emp= this.employerService.registerEmployer(employer);
		return emp;
	}
		
	// Get Employer by Id
	@GetMapping("/employer/{id}")
	public Employer getEmployer(@PathVariable("id") int id)
	{
		return this.employerService.getEmployerById(id);
	}
	
	// Updating Employer
	@PutMapping("/employer/{id}")
	public Employer updateEmployer(@RequestBody Employer employer, @PathVariable("id") int id)
	{
		this.employerService.updateEmployer(employer, id);
		
		return employer;
	}
	
	@DeleteMapping("/employer/{id}")
	public void deleteEmployer(@PathVariable("id") int Id)
	{
		this.employerService.deleteEmployer(Id);
	}
	
	//Job Methods
	
	// get All Jobs
		@GetMapping("/joblist")
		public List<Job> getJobs()
		{
			return this.jobService.getJobs();
		}
		
		// add New Job
		@PostMapping("/jobs")
		public Job addJobs(@RequestBody Job job)
		{
			this.jobService.addJobs(job);
			return job;
		}
		
		// find Job by Id
		@GetMapping("/jobs/{id}")
		public Job getJobById(@PathVariable("id") int id)
		{
			Job result= this.jobService.getJobbyId(id);
			return result;
			
		}
		
		// update Job by Id
		@PutMapping("/jobs/{id}")
		public void updateJobById(@RequestBody Job job, @PathVariable("id") int id)
		{
			this.jobService.updateJobbyId(job, id);
		}
		
		// delete job by Id
		@DeleteMapping("/jobs/{id}")
		public void deleteJobById(@PathVariable("id") int id)
		{
			this.jobService.deleteJobById(id);
		}
	
}
