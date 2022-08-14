package com.jobportal.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.JobSeeker;
import com.jobportal.spring.services.JobSeekerService;
import com.jobportal.spring.services.JobService;

@Controller
@RequestMapping("/jobseeker")
public class WebJobSeekerController {
	
	@Autowired
	JobSeekerService jobseekerservice;
	
	@Autowired
	JobService jobservice;
	
	@GetMapping("/dashboard/{Id}")	
	public String JobSeekerDashboard(Model model, @PathVariable("Id") int id) {

		JobSeeker jobseeker= jobseekerservice.getJobSeeker(id);
		model.addAttribute("jobseeker",jobseeker);
		model.addAttribute("jobs", jobseeker.getJob());
		return "jobseekerdashboard";
	}
	
	// edit profile
		@GetMapping("/editprofile/{id}")
		public String EditProfile(Model model, @PathVariable("id") int id) {
								
//			Employer employer = employerService.getEmployerById(id);
//			model.addAttribute("employer", employer);
			JobSeeker jobseeker=jobseekerservice.getJobSeeker(id);
			model.addAttribute("jobseeker",jobseeker);
//							
			return "editjobseekerprofile";
		}
		
		 //update profile
		@PostMapping("/updateprofile/{id}")
		public String UpdateProfile(Model model, @ModelAttribute JobSeeker jobseeker, @PathVariable("id") int id)
		{
			jobseekerservice.updateJobSeeker(jobseeker,id);
//			employerService.updateEmployer(employer, id);
			return "redirect:/jobseeker/dashboard/"+id;
		}
}
