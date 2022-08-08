package com.jobportal.spring.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jobportal.spring.services.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService myuserDetailService;
	
	@Autowired
	private JwtAuthFilter jwtAuthFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		try
		{
			auth.userDetailsService(myuserDetailService);
		}
		catch(Exception e)
		{
			throw new Exception("Error", e);	
		}
		
		

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/userlogin").permitAll()
		.anyRequest().authenticated();
		
//		.antMatchers("/userlogin").permitAll()
//		.and().authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN")
//		.and().authorizeRequests().antMatchers("/user/**").hasAuthority("USER");
//		.antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/employer/**").hasRole("EMPLOYER")
//		.antMatchers("/user/**").hasRole("USER")
//		.antMatchers("/").permitAll();
		
		
		http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
