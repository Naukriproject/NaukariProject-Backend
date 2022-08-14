package com.jobportal.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.jobportal.spring.dao.EmployerRepository;
import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.Job;
import com.jobportal.spring.entities.JobSeeker;
import com.jobportal.spring.services.EmployerService;
import com.jobportal.spring.services.JobService;

@Controller
@RequestMapping("/employer")
public class WebEmployerController {

	@Autowired
	EmployerService employerService;

	@Autowired
	JobService jobService;
	
	@Autowired
	EmployerRepository empRepo;

	// profile
	@GetMapping("/dashboard/{Id}")
	public String EmployerDashboard(Model model, @PathVariable("Id") int id) {

		Employer employer = employerService.getEmployerById(id);
		model.addAttribute("employer", employer);
		model.addAttribute("jobs", employer.getJobs());
		
		return "empdashboard";
	}
	
	// edit profile
	@GetMapping("/editprofile/{id}")
	public String EditProfile(Model model, @PathVariable("id") int id) {
							
		Employer employer = employerService.getEmployerById(id);
		model.addAttribute("employer", employer);
						
		return "editempprofile";
	}
	
	 //update profile
	@PostMapping("/updateprofile/{id}")
	public String UpdateProfile(Model model, @ModelAttribute Employer employer, @PathVariable("id") int id)
	{
		employerService.updateEmployer(employer, id);
		return "redirect:/employer/dashboard/"+id;
	}
	
	// job list of employer
	@GetMapping("myjoblist/{Id}")
	public String ViewJobs(Model model, @PathVariable("Id") int id)
	{
		Employer employer = employerService.getEmployerById(id);
		
		List<Job> job = employer.getJobs();
		model.addAttribute("jobs", job);
			
		return "empjoblist";
	}
	
	// applied job list of employer
	@GetMapping("appliedjoblist/{Id}")
	public String ViewAppliedJobs(Model model, @PathVariable("Id") int id)
	{
		Job job = jobService.getJobbyId(id);
				
		model.addAttribute("jobs", job);
		model.addAttribute("seekers", job.getJobSeeker());
			
		return "empjobapplied";
	}
	
	// add job page
	@GetMapping("/addjob/{id}")
	public String Addjob(Model model, @PathVariable("id") int id) {
		
		Job job = new Job();
		
		model.addAttribute("job", job);
		model.addAttribute("id", id);
		return "addjob";
	}
	
	//Update job
	@GetMapping("/editjob/{id}")
	public String editjob(Model model, @PathVariable("id") int id)
	{
		Job job=jobService.getJobbyId(id);
		model.addAttribute("job",job);
		
		return "editjob";
	}
	
	// update job
	@PostMapping("/updatejob/{id}")
	public String updaejob(Model model, @ModelAttribute Job job, @PathVariable("id") int id) {
		
		Job jobs = this.jobService.getJobbyId(id);
		job.setEmployer(jobs.getEmployer());
		Employer employer = jobs.getEmployer();
		
		jobService.updateJobbyId(job,id);
		return "redirect:/employer/myjoblist/" + employer.getEmployerId();
	}
	
	// save job method
	@PostMapping("/save/{id}")
	public String Save(Model model, @ModelAttribute Job job, @PathVariable("id") int id) {
		Employer employer = employerService.getEmployerById(id);
		job.setEmployer(employer);
		jobService.addJobs(job);
		return "redirect:/employer/dashboard/"+id;
	}
	
	// delete job by Id
	@GetMapping("/deletejob/{id}")
	public String deleteJobById(@PathVariable("id") int id)
	{
		Job job = this.jobService.getJobbyId(id);
		Employer employer = job.getEmployer();
		this.jobService.deleteJobById(id);
		return "redirect:/employer/myjoblist/" + employer.getEmployerId();
	}

}
