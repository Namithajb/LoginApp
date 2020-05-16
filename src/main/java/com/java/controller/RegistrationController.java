package com.java.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.User;
import com.java.service.UserService;
//import com.java.validation.*;

//import jakarta.validation.Valid;

@Controller
public class RegistrationController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user,BindingResult br) {
		
		if(br.hasErrors())
		{
			return "registration";
		}
		else
		{
			userService.addUser(user);

			return "welcome";
		}
		
	}
}	
		
				

		
		
		