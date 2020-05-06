package com.java.dao;



import com.java.model.Invoice;
import com.java.model.Login;
import com.java.model.User;


public interface UserDAO {

	  int addUser(User user);

	  User validateUser(Login login);
	  
	  
	}
