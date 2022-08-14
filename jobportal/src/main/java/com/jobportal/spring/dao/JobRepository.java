package com.jobportal.spring.dao;



import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Component;

import com.jobportal.spring.entities.Job;

@Component
public interface JobRepository extends CrudRepository<Job, Integer>{

//	@Query("select u.employer from Job u where u.jobId= :jobId")
//	Integer getEmpidbyJobId(@Param("jobId") int jobId);
}
