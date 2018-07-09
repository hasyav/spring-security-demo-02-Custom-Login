package com.love2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
//over ride methods
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{

	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
//	add our users for in memory aythentication - creates a default login form 
		UserBuilder user = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(user.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(user.username("Mary").password("test123").roles("EMPLOYEE","MANAGER"))
						.withUser(user.username("suzan").password("test123").roles("EMPLOYEE","ADMIN"));
	}
	
	
	@Override
//	security for custom login and logout
	protected void configure(HttpSecurity http) throws Exception{
//	restrict access based on servelet request comming in	
		http.authorizeRequests()
		
//	any request to the app must be authenticated	- user must be logged in
//		.anyRequest().authenticated() -- remove this for role based access
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/leaders/**").hasRole("MANAGER")
		.antMatchers("/systems/**").hasRole("ADMIN")
		.and()
//	custamization of login	
		.formLogin()
//		custom login page
		.loginPage("/showMyLoginPage")
//		Login form should POST data to this URL for processing data - check the userId and password 
		.loginProcessingUrl("/authenticateTheUser")
//		Allow everyone to access the authentication - without logging in 
		.permitAll()
		.and()
		//logout support for this login page
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
}
