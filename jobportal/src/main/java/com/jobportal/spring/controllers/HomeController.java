package com.jobportal.spring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/index")
	public String homepage()
	{
		return "Welcome to Home Page";
	}
	
	@GetMapping("/jobs")
	public String jobs()
	{
		return "Welcome to Job Page";
	}
	
	@GetMapping("/jobs/{id}")
	public String jobsbyId(@PathVariable("id") int id)
	{
		return "Welcome to Job Details Page";
	}
}
