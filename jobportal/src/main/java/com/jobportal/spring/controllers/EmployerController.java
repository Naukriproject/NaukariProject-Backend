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

import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.services.EmployerService;



@RestController
public class EmployerController {

	@Autowired
	private EmployerService employerService;
	
	// Get All Employees
	@GetMapping("/employer")
	public List<Employer> getAllEmployee()
	{
		return this.employerService.getEmployer();
		
	}
	
	// Employer Registration
	@PostMapping("/employer")
	public Employer employerRegistration(@RequestBody Employer employer)
	{
		Employer emp= this.employerService.registerEmployer(employer);
		return emp;
	}
		
	// Get Employer by Id
	@GetMapping("/employer/{id}")
	public Optional<Employer> getEmployer(@PathVariable("id") int id)
	{
		return this.employerService.getEmployerById(id);
	}
	
	// Updating Employer
	@PutMapping("/employer/{id}")
	public Employer updateEmployer(@RequestBody Employer employer, @PathVariable("id") int id)
	{
		this.employerService.updateEmployer(employer, id);
		
		return employer;
	}
	
	@DeleteMapping("/employer/{id}")
	public void deleteEmployer(@PathVariable("id") int Id)
	{
		this.employerService.deleteEmployer(Id);
	}
	
	
	
}
