package com.java;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * auth.jdbcAuthentication().dataSource(dataSource)
		 * .usersByUsernameQuery("Select \"admin\",\"admin\",true where 1=1;")
		 * .authoritiesByUsernameQuery("Select \"admin\",\"admin\" where 1=1;");
		 */

		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource)
				.usersByUsernameQuery("select username as principal, password as credentials, true from user.user where username = ?").rolePrefix("ROLE_");
				//.authoritiesByUsernameQuery("select username as principal, role as role from user.authority where username = ?");  
																												// ;

//		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());Fs

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/home").permitAll()

				.antMatchers("/showRegistrationPage").permitAll().antMatchers("/registrationProcess").permitAll()

				.anyRequest().authenticated().

				and()

				.formLogin().loginPage("/showLoginPage").permitAll().loginProcessingUrl("/login")

				.defaultSuccessUrl("/login").failureUrl("/showLoginPage?error=true").permitAll().and().logout()
				.logoutSuccessUrl("/showLoginPage?logout=true").invalidateHttpSession(true).permitAll();
		http.authorizeRequests().antMatchers("/Edit/**").hasRole("ADMIN")

				.antMatchers("/Delete/**").hasRole("ADMIN")

				.and()

				.exceptionHandling().accessDeniedPage("/403").and()

				.csrf();

	}

}
