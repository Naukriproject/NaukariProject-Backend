package com.jobportal.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.spring.entities.Employer;
import com.jobportal.spring.entities.JobSeeker;
import com.jobportal.spring.entities.User;
import com.jobportal.spring.model.AuthenticationRequest;
import com.jobportal.spring.model.AuthenticationResponse;
import com.jobportal.spring.services.EmployerService;
import com.jobportal.spring.services.EmployerUserDetailsService;
import com.jobportal.spring.services.JobSeekerService;
import com.jobportal.spring.services.JobSeekerUserDetailsService;
import com.jobportal.spring.services.JobService;
import com.jobportal.spring.services.MyUserDetails;
import com.jobportal.spring.services.MyUserDetailsService;
import com.jobportal.spring.services.UserService;
import com.jobportal.spring.util.JwtUtil;

@RestController
public class LoginController {

	@Autowired
	private JwtUtil jwtutil;

//	@Autowired
//    private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private EmployerUserDetailsService empUserDetailService;
	
	@Autowired
	private JobSeekerUserDetailsService seekerUserDetailService;

	@Autowired
	private AuthenticationManager authenticationManager;

//	@Autowired
//	private UserService userService;

	@Autowired
	private EmployerService employerservice;

	@Autowired
	private JobSeekerService jobseekerservice;

	@PostMapping("/employer")
	public Employer employerRegister(@RequestBody Employer employer) {
		Employer result = employerservice.registerEmployer(employer);
		return result;
	}

	@PostMapping("/jobseeker")
	public JobSeeker jobseeker(@RequestBody JobSeeker jobseeker) {
		JobSeeker result = jobseekerservice.addJobSeeker(jobseeker);
		return result;
	}

	@PostMapping("/employerlogin")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or Password", e);
		}
		final UserDetails userDetails = empUserDetailService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtutil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
//	@PostMapping("/jobseekerlogin")
//	public ResponseEntity<?> createSeekerAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
//			throws Exception {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//		} catch (BadCredentialsException e) {
//			throw new Exception("Incorrect Username or Password", e);
//		}
//		final UserDetails userDetails = seekerUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
//
//		final String jwt = jwtutil.generateToken(userDetails);
//
//		return ResponseEntity.ok(new AuthenticationResponse(jwt));
//	}

//		@PostMapping("/register")
//		public User userregister(@RequestBody User user)
//		{
//			User result=userService.addUser(user);
//			return result;
//		}

//		@PostMapping("/userlogin")
//		public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
//		{
//			try
//			{
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
//					authenticationRequest.getPassword()));
//			}
//			catch(BadCredentialsException e)
//			{
//				throw new Exception("Incorrect Username or Password", e);
//			}
//			final UserDetails userDetails= myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//			
//			final String jwt=jwtutil.generateToken(userDetails);
//			
//			return ResponseEntity.ok(new AuthenticationResponse(jwt));
//		}
}
