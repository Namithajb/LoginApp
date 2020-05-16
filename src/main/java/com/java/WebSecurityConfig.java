package com.java;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	
	 @Autowired
	 DataSource dataSource;
	
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	   auth.jdbcAuthentication().dataSource(dataSource).
	   usersByUsernameQuery("select username,password  from user where role=?");
	   System.out.println("login");
	 }
	   
	   @Override
	   protected void configure(HttpSecurity http) throws Exception {

		   http.authorizeRequests()
		   .antMatchers("/home").access("hasRole('Admin')")  
		   .anyRequest().permitAll()
		   .and()
		     .formLogin().loginPage("/login")
		     .usernameParameter("username").passwordParameter("password")
		   .and()
		     .logout().logoutSuccessUrl("/login?logout") 
		    .and()
		    
		  .csrf();

	
	
	
	
	
	   }
	
}
