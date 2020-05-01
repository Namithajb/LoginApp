package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.model.User;
import com.java.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	public UserService userService;

	@RequestMapping(value = "/registrationProcess", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, ModelMap model) {
		userService.addUser(user);
		model.addAttribute("username", user.getUsername());
		return "welcome" ;
	}
}
