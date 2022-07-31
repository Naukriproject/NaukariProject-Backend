package com.jobportal.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobportal.spring.dao.UserRepository;
import com.jobportal.spring.entities.User;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user)
	{
		return this.userRepository.save(user);
	}

}
