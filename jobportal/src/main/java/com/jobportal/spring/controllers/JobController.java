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
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.spring.entities.Job;
import com.jobportal.spring.services.JobService;

@RestController
public class JobController {

	@Autowired
	private JobService jobService;
	
	
	// get All Jobs
	@GetMapping("/jobs")
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
	public Optional<Job> getJobById(@PathVariable("id") int id)
	{
		Optional<Job> result= this.jobService.getJobbyId(id);
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
