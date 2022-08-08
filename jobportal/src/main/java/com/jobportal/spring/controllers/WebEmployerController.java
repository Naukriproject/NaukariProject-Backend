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
import com.jobportal.spring.entities.Job;
import com.jobportal.spring.services.EmployerService;
import com.jobportal.spring.services.JobService;

@Controller
@RequestMapping("/webemployer")
public class WebEmployerController {

	@Autowired
	EmployerService employerService;

	@Autowired
	JobService jobService;

	@GetMapping("/dashboard/{Id}")
	public String EmployerDashboard(Model model, @PathVariable("Id") int id) {

		Employer employer = employerService.getEmployerById(id);
		model.addAttribute("employer", employer);

		return "empdashboard";
	}

	@GetMapping("/addjob")
	public String Addjob(Model model) {
		Job job = new Job();
		model.addAttribute("job", job);
		return "addjob";
	}

	@PostMapping("/save")
	public String Save(Model model, @ModelAttribute Job job) {
		jobService.addJobs(job);
//		model.addAttribute("job", job);
		return "addjob";
	}

}
