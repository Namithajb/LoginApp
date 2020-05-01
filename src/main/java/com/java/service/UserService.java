package com.java.service;

import org.springframework.stereotype.Service;

import com.java.model.Login;
import com.java.model.User;

@Service
public interface UserService {

	int addUser(User user);

	User validateUser(Login login);
}