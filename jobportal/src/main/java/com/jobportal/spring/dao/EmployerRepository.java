package com.jobportal.spring.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jobportal.spring.entities.Employer;

public interface EmployerRepository extends CrudRepository<Employer, Integer> {
	
//	@Query("select u from Employer u where u.email= : email")
//	public Employer getEmployerByUserName(@Param("email") String email);
}
