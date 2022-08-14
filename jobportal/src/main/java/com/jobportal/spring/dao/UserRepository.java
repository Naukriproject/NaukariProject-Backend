package com.jobportal.spring.dao;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.jobportal.spring.entities.User;
@Component
public interface UserRepository extends CrudRepository<User, Integer>{
	
	Optional<User> findByUsername(String userName);

}
