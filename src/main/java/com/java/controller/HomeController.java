package com.java.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.Login;
import com.java.model.User;
import com.java.service.UserService;

@Controller
public class HomeController {

	@Autowired
	public UserService userService;

	@RequestMapping("/")
	public String home(Map<String, Object> map) {
		return "home";
	}

	@RequestMapping("/showLoginPage")
	public String showLoginPage(ModelMap model) {
		model.addAttribute(new Login());

		return "login";
	}


	 

	
	 
	
	@RequestMapping("/showRegistrationPage")
	public String showRegistrationPage(ModelMap model) {
		model.addAttribute(new User());

		return "registration";
	}

}
