package com.java;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
public class AuthenticationProvider {

	@Autowired
	DataSource dataSource;
	
	@Bean(name="userDetailsService")
	public UserDetailsService userDetailsService()
	{
		
		JdbcDaoImpl jdbcImpl=new JdbcDaoImpl();
		jdbcImpl.setDataSource(dataSource);
		jdbcImpl.setUsersByUsernameQuery("select username as principal, password as credentials, true from user.user where username = ?");
		jdbcImpl.setAuthoritiesByUsernameQuery("select username as principal, role as role from user.authority where username = ?");
		return jdbcImpl;
	}
	
	
	
	
	
	
	
}
