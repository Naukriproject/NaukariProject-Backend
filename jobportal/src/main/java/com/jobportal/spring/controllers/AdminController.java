package com.jobportal.spring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	public String Dashboard()
	{
		return "Welcome to Admin Dashboard";
	}

}