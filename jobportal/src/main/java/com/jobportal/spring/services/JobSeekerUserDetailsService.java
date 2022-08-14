package com.jobportal.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jobportal.spring.dao.EmployerRepository;
import com.jobportal.spring.dao.JobSeekerRepository;
import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.JobSeeker;

@Component
public class JobSeekerUserDetailsService implements UserDetailsService {

	@Autowired
	JobSeekerRepository jobSeekerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		Optional<JobSeeker> jobSeeker = jobSeekerRepository.findByEmail(username);
//		jobSeeker.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

		//MyUserDetails myUserDetail =user.map(MyUserDetails::new).get();
		
		//return jobSeeker.map(MyUserDetails::new).get();
		return null;
		
		
	}

}
