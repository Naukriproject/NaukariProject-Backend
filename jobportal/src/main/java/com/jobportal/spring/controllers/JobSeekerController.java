package com.jobportal.spring.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.spring.entities.JobSeeker;
import com.jobportal.spring.services.JobSeekerService;
import com.jobportal.spring.services.MyUserDetailsService;
import com.jobportal.spring.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class JobSeekerController {
	
	@Autowired
	JobSeekerService jobSeekerService;
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	
	// get Employee List
	@GetMapping("/jobseeker")
	public List<JobSeeker> getList()
	{
				
		return this.jobSeekerService.getJobSeeker();
	}
	
	// get Employee by Id
	@GetMapping("/jobseeker/{Id}")
	public JobSeeker getListById(@PathVariable("Id") int Id)
	{
		return this.jobSeekerService.getJobSeeker(Id);
	}
	
	// add Employee
	@PostMapping("/jobseeker")
	public JobSeeker addEmployee(@RequestBody() JobSeeker jobseeker)
	{
		JobSeeker result = this.jobSeekerService.addJobSeeker(jobseeker);
		return result;
	}
	
	// update Employee by Id 
	@PutMapping("/jobseeker/{Id}")
	public JobSeeker updateEmployee(@RequestBody() JobSeeker jobseeker, @PathVariable("Id") int Id)
	{
		this.jobSeekerService.updateJobSeeker(jobseeker, Id);
		return jobseeker;
	}
	
	// delete employee by id
	@DeleteMapping("/jobseeker/{Id}")
	public void deleteEmployee(@PathVariable("Id") int Id) 
	{
		this.jobSeekerService.deleteJobSeeker(Id);
	}

}
