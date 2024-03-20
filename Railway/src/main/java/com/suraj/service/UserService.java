package com.suraj.service;

import java.util.List;

import com.suraj.model.User;

public interface UserService {

	User createUser(User user);	
	List<User> getAllUsers();
	User getUser(int uid);
	User updateUser(int userid,User user);
	String deleteUser(int userid);
}
