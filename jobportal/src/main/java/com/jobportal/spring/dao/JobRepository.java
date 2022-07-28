package com.jobportal.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.spring.entities.Job;

public interface JobRepository extends CrudRepository<Job, Integer>{

}
