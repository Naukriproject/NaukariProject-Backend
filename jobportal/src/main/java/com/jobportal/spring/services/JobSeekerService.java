package com.jobportal.spring.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jobportal.spring.dao.JobSeekerRepository;
import com.jobportal.spring.entities.JobSeeker;

@Component
public class JobSeekerService {
	
	@Autowired
	private JobSeekerRepository jobSeekerRepository;
	
	// get Employee List	
	public List<JobSeeker> getJobSeeker()
	{
		List<JobSeeker> list=(List<JobSeeker>)this.jobSeekerRepository.findAll();
		return list;
	}
	
	// add new Employee
	public JobSeeker addJobSeeker(JobSeeker jobSeeker)
	{
		JobSeeker result = this.jobSeekerRepository.save(jobSeeker);
		return result;
		
	}
	
	// get Employee by Id
	public JobSeeker getJobSeeker(int Id)
	{
//		Optional<JobSeeker> jobSeeker=null;
		
		JobSeeker jobSeeker=null;
		try
		{
			Optional<JobSeeker> jobSeek = this.jobSeekerRepository.findById(Id);
			jobSeeker=jobSeek.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return jobSeeker;
	}
	
	// delete Employee by Id
	public void deleteJobSeeker(int Id)
	{
		this.jobSeekerRepository.deleteById(Id);
	}
	
	
	// update Employee
	public void updateJobSeeker(JobSeeker jobSeeker, int Id)
	{
		//jobSeeker.se(Id);
		jobSeeker.setJobSeekerId(Id);
		this.jobSeekerRepository.save(jobSeeker);
		
	}

}
