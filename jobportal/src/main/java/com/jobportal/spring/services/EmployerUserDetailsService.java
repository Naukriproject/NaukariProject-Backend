package com.jobportal.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jobportal.spring.dao.EmployerRepository;
import com.jobportal.spring.entities.Employer;

@Component
public class EmployerUserDetailsService implements UserDetailsService {

	@Autowired
	EmployerRepository employerrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Employer> employer = employerrepository.findByemail(username);
		employer.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

		
		
		return employer.map(MyUserDetails::new).get();
		
		
	}

}
