package com.jobportal.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jobportal.spring.entities.Employee;
import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.Job;
import com.jobportal.spring.services.JobService;




@Controller
public class HomeController {

	@Autowired
	JobService jobService;
	
	@GetMapping({"/index", "/"})
	public String homepage(Model model)
	{
		List<Job> job = jobService.getJobs();
		model.addAttribute("job",job);
		return "index";
	}
	
	@GetMapping("/login")
	public String loginpage()
	{
		return "login";
	}
	
	@GetMapping("/signup")
	public String signuppage(Model model)
	{
		Employee employee = new Employee();
		Employer employer = new Employer();
		model.addAttribute("employee", employee);
		model.addAttribute("employer", employer);
		return "signup";
	}
	@PostMapping("/saveemployee")
	public String SaveEmployee(Model model, @ModelAttribute Employee employee)
	{	
		
		return "signup";
	}
	
	@PostMapping("/saveemployer")
	public String SaveEmployer(Model model, @ModelAttribute Employer employer)
	{	
		
		return "signup";
	}
	
	@GetMapping("/jobs")
	public String jobs(Model model)
	{
		List<Job> job = jobService.getJobs();
		model.addAttribute("job",job);
		return "joblist";
	}
	@GetMapping("/jobs/{id}")
	public String jobdetail(@PathVariable("id") int Id, Model model)
	{
	    Job job = jobService.getJobbyId(Id);
	    model.addAttribute("job",job);
	    //model.addAttribute("employer", job.getEmployer());
		return "jobdetail";
	}
	

}
