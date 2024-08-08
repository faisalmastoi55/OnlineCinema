package com.cinema.dao;

import com.cinema.entities.User;

public interface UserService {
	
	Boolean userRegister(User user);
	
	Boolean checkUser(String email);
	
	User login(String email, String password);
	
	User getUserById(int id);

}
