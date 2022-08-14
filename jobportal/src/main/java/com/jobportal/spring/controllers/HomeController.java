package com.jobportal.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jobportal.spring.entities.JobSeeker;
import com.jobportal.spring.dao.JobSeekerRepository;
import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.Job;

import com.jobportal.spring.services.EmployerService;
import com.jobportal.spring.services.JobSeekerService;
import com.jobportal.spring.services.JobService;

@Controller
public class HomeController {

	@Autowired
	JobService jobService;
	
	@Autowired
	EmployerService employerService;
	
	@Autowired
	JobSeekerService jobseekerService;
	
	// home page
	@GetMapping({"/index", "/"})
	public String homepage(Model model)
	{
		List<Job> job = jobService.getJobs();
		model.addAttribute("job",job);
		return "index";
	}
	
	// login page
	@GetMapping("/login")
	public String loginpage()
	{
		return "login";
	}
	
	// signup page
	@GetMapping("/signup")
	public String signuppage(Model model)
	{
		JobSeeker jobseeker = new JobSeeker();
		Employer employer = new Employer();
		model.addAttribute("jobseeker", jobseeker);
		model.addAttribute("employer", employer);
		return "signup";
	}
	
	// save jobseeker
	@PostMapping("/savejobseeker")
	public String SaveJobSeeker(Model model, @ModelAttribute JobSeeker jobseeker)
	{	
		jobseeker.setActive(true);
		jobseeker.setRoles("USER");
		jobseekerService.addJobSeeker(jobseeker);
		
		Employer employer=new Employer();
		model.addAttribute("employer",employer);
		model.addAttribute("jobseeker",jobseeker);
		return "signup";
	}
	
	// save employer
	@PostMapping("/saveemployer")
	public String SaveEmployer(Model model, @ModelAttribute Employer employer)
	{	
		employer.setRoles("EMPLOYER");
		employer.setActive(true);
		employerService.registerEmployer(employer);
		
		JobSeeker jobseeker = new JobSeeker();
		model.addAttribute("jobseeker",jobseeker);
		
		return "signup";
	}
	
	// job list on jobs page
	@GetMapping("/jobs")
	public String jobs(Model model)
	{
		List<Job> job = jobService.getJobs();
		model.addAttribute("job",job);
		return "joblist";
	}
	
	// job details by id
	@GetMapping("/jobs/{id}")
	public String jobdetail(@PathVariable("id") int Id, Model model)
	{
	    Job job = jobService.getJobbyId(Id);
	    model.addAttribute("job",job);
	    model.addAttribute("employer", job.getEmployer());
		return "jobdetail";
	}
	
	
	
	@GetMapping("/applyjobpage/{id}")
	public String jobdetailpage(@PathVariable("id") int Id, Model model)
	{
	    Job job = jobService.getJobbyId(Id);
	    model.addAttribute("job",job);
	    //model.addAttribute("employer", job.getEmployer());
		return "applyjob";
	}
	
	 //Apply Jobs
	@PostMapping("/applyjob/{id}")
	public String applyjob(Model model, @ModelAttribute Job job, @PathVariable("id") int id)
	{ 	
//		Job newjob = jobService.getJobbyId(job.getJobId());
		
//		JobSeeker jobSeeker= jobseekerService.getJobSeeker(id);
//		List<JobSeeker> njobseeker = new ArrayList<>();
//		njobseeker.add(jobSeeker);
//		
//		job.setJobSeeker(njobseeker);
//		
//		jobService.addJobs(job);
		
		Job jobnew = jobService.getJobbyId(job.getJobId());
		JobSeeker jobSeeker= jobseekerService.getJobSeeker(id);
		
		jobnew.getJobSeeker().add(jobSeeker);
		jobSeeker.getJob().add(jobnew);
		
		//int jobid = job.getJobId();
		
		jobseekerService.addJobSeeker(jobSeeker);
		jobService.addJobs(jobnew);
				
		return "redirect:/index";
	}

}
