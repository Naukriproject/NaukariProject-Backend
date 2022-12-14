package com.jobportal.spring.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.User;

@Component
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
	
	Optional<Employer> findByemail(String email);
}
