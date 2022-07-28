package com.jobportal.spring.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jobportal.spring.entities.Employee;
import com.jobportal.spring.entities.Employer;

public class LoginController {
	
	
	//change to model
		@PostMapping("/employer-login")
		public Employer EmployerLogin(@RequestBody Employer employer)
		{
			return null;
		}
		
		@PostMapping("/user-login")
		public Employee UserLogin(@RequestBody Employee employee)
		{
			return null;
		}
}
