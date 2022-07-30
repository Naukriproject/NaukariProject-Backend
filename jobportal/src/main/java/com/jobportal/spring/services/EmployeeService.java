package com.jobportal.spring.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jobportal.spring.dao.EmployeeRepository;
import com.jobportal.spring.entities.Employee;

@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	// get Employee List	
	public List<Employee> getEmployee()
	{
		List<Employee> list=(List<Employee>)this.employeeRepository.findAll();
		return list;
	}
	
	// add new Employee
	public Employee addEmployee(Employee emp)
	{
		Employee result = this.employeeRepository.save(emp);
		return result;
		
	}
	
	// get Employee by Id
	public Optional<Employee> getEmployee(int Id)
	{
		Optional<Employee> employee=null;
		try
		{
			employee = this.employeeRepository.findById(Id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return employee;
	}
	
	// delete Employee by Id
	public void deleteEmployee(int Id)
	{
		this.employeeRepository.deleteById(Id);
	}
	
	
	// update Employee
	public void updateEmployee(Employee employee, int Id)
	{
		employee.setEmployee_Id(Id);
		this.employeeRepository.save(employee);
		
	}

}
