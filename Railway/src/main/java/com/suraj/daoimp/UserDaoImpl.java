package com.suraj.daoimp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.suraj.dao.UserDao;
import com.suraj.model.User;
import com.suraj.utility.HibernateUtil;


public class UserDaoImpl implements UserDao {

	public User createUser(User user) {
		try(Session session=HibernateUtil.getSesssion()){
			
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return user;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	  @Override
	    public List<User> getAllUsers() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.createQuery("FROM User", User.class).list();
	        } catch (HibernateException e) {
	            System.out.println(e);
	        }
	        return null;
	    }
	    
	    @Override
		public User getUser(int userId) {
	    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            return session.get(User.class, userId);
	        } catch (HibernateException e) {
	            System.out.println(e);
	        }
	        return null;
		}




		@Override
		public User updateUser(int userId, User user) {
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		        session.beginTransaction();
		        User existingUser = session.get(User.class, userId);
		        if (existingUser != null) {
		            existingUser.setName(user.getName());
		            existingUser.setPhone(user.getPhone());
		            // set other fields as needed
		            existingUser.setUserid(user.getUserid()); // Setting user id
		            session.update(existingUser);
		            session.getTransaction().commit();
		            return existingUser;
		        }
		    } catch (HibernateException e) {
		        System.out.println(e);
		    }
		    return null;
		}




		@Override
		public String deleteUser(int userId) {
			 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		            session.beginTransaction();
		            User user = session.get(User.class, userId);
		            if (user != null) {
		                session.delete(user);
		                session.getTransaction().commit();
		                return "User deleted successfully.";
		            }
		        } catch (HibernateException e) {
		            System.out.println(e);
		        }
		        return "Failed to delete user.";
		    
		}

	
	
}
	    








































