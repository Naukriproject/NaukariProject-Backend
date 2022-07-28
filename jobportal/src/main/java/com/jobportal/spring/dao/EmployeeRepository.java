package com.jobportal.spring.dao;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.spring.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
