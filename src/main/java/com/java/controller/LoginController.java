package com.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.model.Login;
import com.java.model.User;
import com.java.service.UserService;

@Controller
public class LoginController {
	@Autowired
	public UserService userService;

	/*
	 * @PostMapping(value = "/loginProcess") public String
	 * login(@ModelAttribute("login") Login login, BindingResult bindingResult,
	 * ModelMap model) {
	 * 
	 * User user = userService.validateUser(login);
	 * 
	 * boolean isValidUser = false;
	 * 
	 * if (null != user && user.getUsername().equals(login.getUsername()) &&
	 * user.getPassword().equals(login.getPassword())) { isValidUser = true;
	 * model.addAttribute("username", user.getUsername()); }
	 * 
	 * return isValidUser ? "welcome" : "login"; }
	 */

	/*
	 * @RequestMapping(value="/login") public String login(){ return "welcome"; }
	 * 
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, ModelMap model,
			@ModelAttribute("login") Login login) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is incorrect !!";
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
		}
		model.addAttribute("errorMessge", errorMessge);
		return "welcome";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "/showLoginPage";
	}

}
