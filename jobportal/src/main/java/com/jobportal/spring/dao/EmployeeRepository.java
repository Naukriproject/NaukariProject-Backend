package com.jobportal.spring.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jobportal.spring.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	
	@Query("select u from Employee u where u.Email= :email")
	public Employee getEmployeeByUserName(@Param("email") String email);
}
