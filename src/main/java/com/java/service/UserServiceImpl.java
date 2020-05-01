package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.UserDAO;
import com.java.model.Login;
import com.java.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDAO userDao;

	public int addUser(User user) {
		return userDao.addUser(user);
	}

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

}
