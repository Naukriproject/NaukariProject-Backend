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

import com.jobportal.spring.entities.Employee;
import com.jobportal.spring.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	// get Employee List
	@GetMapping("/employee")
	public List<Employee> getList()
	{
		return this.employeeService.getEmployee();
	}
	
	// get Employee by Id
	@GetMapping("/employee/{Id}")
	public Optional<Employee> getListById(@PathVariable("Id") int Id)
	{
		return this.employeeService.getEmployee(Id);
	}
	
	// add Employee
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody() Employee employee)
	{
		Employee result = this.employeeService.addEmployee(employee);
		return result;
	}
	
	// update Employee by Id 
	@PutMapping("/employee/{Id}")
	public Employee updateEmployee(@RequestBody() Employee employee, @PathVariable("Id") int Id)
	{
		this.employeeService.updateEmployee(employee, Id);
		return employee;
	}
	
	// delete employee by id
	@DeleteMapping("/employee/{Id}")
	public void deleteEmployee(@PathVariable("Id") int Id) 
	{
		this.employeeService.deleteEmployee(Id);
	}

}
