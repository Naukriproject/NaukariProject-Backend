package com.jobportal.spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobportal.spring.dao.JobRepository;
import com.jobportal.spring.dao.JobSeekerRepository;
import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.Job;
import com.jobportal.spring.entities.JobSeeker;

@Component
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	
	// get All Jobs
	public List<Job> getJobs()
	{
	 	List<Job> list =(List<Job>)this.jobRepository.findAll();
		return list;
	}

	// add new Job
	public Job addJobs(Job job) {
		Job result = this.jobRepository.save(job);
		return result;
		
	}
	
	
	//get job by Id
	public Job getJobbyId(int id)
	{
		Job job=null;
		try
		{
			Optional<Job> optjob= this.jobRepository.findById(id);
			job=optjob.get();
			
		}
		catch(Exception e)
		{
			
		}
		
		return job;
	}
	
	//update job by Id
	public void updateJobbyId(Job job, int id)
	{
		job.setJobId(id);
		this.jobRepository.save(job);
	}
	
	
	//update applied in job
	public void updatetAppliedJobbyId(int id, JobSeeker jobseeker)
	{
		Job job=null;
		Optional<Job> optjob= this.jobRepository.findById(id);
		job = optjob.get();
				
		job.getJobSeeker().add(jobseeker);
		//jobseeker.getJob().add(job);
	
		jobRepository.save(job);
		
	}
	
	// delete job by Id
	public void deleteJobById(int id)
	{
		this.jobRepository.deleteById(id);
	}

}
