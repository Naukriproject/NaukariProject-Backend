package com.jobportal.spring.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.jobportal.spring.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	Optional<User> findByUsername(String userName);

}
