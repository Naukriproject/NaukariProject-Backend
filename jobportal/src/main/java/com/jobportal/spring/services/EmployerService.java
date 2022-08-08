package com.jobportal.spring.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobportal.spring.dao.EmployerRepository;
import com.jobportal.spring.entities.Employer;

@Component
public class EmployerService {
	
	
	@Autowired
	private EmployerRepository employerRepository;
	
	
	// Employers list
	public List<Employer> getEmployer()
	{
		List<Employer> list = (List<Employer>)this.employerRepository.findAll();
		return list;
	}
		
	//add new employer
	public Employer registerEmployer(Employer emp)
	{
		Employer result= employerRepository.save(emp);
		return result;
	}
	
	//get employer by id
	public Employer getEmployerById(int id)
	{
		Employer employer=null;
		try
		{
		 	Optional<Employer> emp = this.employerRepository.findById(id);
		 	
		 	employer=emp.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return employer;
		
	}
	
	
	
	//delete employer
	public void deleteEmployer(int id)
	{
		this.employerRepository.deleteById(id);
	}

	// update employer
	public void updateEmployer(Employer employer, int id) {

		employer.setEmployer_Id(id);
		this.employerRepository.save(employer);
		
	}
	

	
}
