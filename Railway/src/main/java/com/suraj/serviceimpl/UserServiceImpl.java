package com.suraj.serviceimpl;

import java.util.List;

import com.suraj.dao.UserDao;
import com.suraj.daoimp.UserDaoImpl;
import com.suraj.model.User;
import com.suraj.service.UserService;

public class UserServiceImpl implements UserService {

		UserDao udao=new UserDaoImpl();
	@Override
		public User createUser (User user) {
			return udao.createUser(user);
		}

	@Override
    public List<User> getAllUsers() {
        
		return udao.getAllUsers();
    }

    @Override
    public User getUser(int userId) {
     
		return udao.getUser(userId);
    }

    @Override
    public User updateUser(int userId, User user) {
        
		return udao.updateUser(userId, user);
    }

    @Override
    public String deleteUser(int userId) {
        
		return udao.deleteUser(userId);
    }

	
	}






































/*import com.suraj.model.User;
import com.suraj.service.UserService;
import com.suraj.dao.UserDao;
import com.suraj.daoimp.UserDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao userdao = new UserDaoImpl();
	@Override
	public User createUser(User user) {
		return userdao.createUser(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userdao.getAllUser();
	}

	//@Override
	public User getUser(String userid) {
		// TODO Auto-generated method stub
		return userdao.getUser(userid);
	}

	@Override
	public User updateUser(int userid, User updatedUser) {
		// TODO Auto-generated method stub
		return userdao.updateUser(userid, updatedUser);
	}

	@Override
	public String deleteUser(int userid) {
		// TODO Auto-generated method stub
		return userdao.deleteUser(userid);
	}

	@Override
	public User getUser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
   
}*/

