package com.jobportal.spring.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.JobSeeker;

@Component
public interface JobSeekerRepository extends CrudRepository<JobSeeker, Integer>{

	//Optional<JobSeeker> findByEmail(String email);
//	@Query("select u from Employee u where u.Email= :email")
//	public JobSeeker getEmployeeByUserName(@Param("email") String email);
}
