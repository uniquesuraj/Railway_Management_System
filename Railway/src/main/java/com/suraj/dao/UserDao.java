package com.suraj.dao;

import java.util.List;


import com.suraj.model.User;

public interface UserDao {
   


User createUser(User user);	
List<User> getAllUsers();
User getUser(int userid);
User updateUser(int userid , User user);
String deleteUser(int userid);
}