package com.jobportal.spring.dao;


import org.springframework.data.repository.CrudRepository;

import com.jobportal.spring.entities.Employer;

public interface EmployerRepository extends CrudRepository<Employer, Integer> {
	

}
