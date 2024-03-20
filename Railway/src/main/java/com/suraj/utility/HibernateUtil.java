package com.suraj.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.suraj.model.Ticket;
import com.suraj.model.Train;
import com.suraj.model.User;


	public class HibernateUtil
	{
		private final static  SessionFactory  sessionFactory=buildSessionFactory();
		private static SessionFactory buildSessionFactory() {
	   
	        try {
	            // Create the SessionFactory from hibernate.cfg.xml
	            return new Configuration().configure("User.cfg.xml")
	            		
	            		.addAnnotatedClass(User.class)
	            		.addAnnotatedClass(Train.class)
	            		.addAnnotatedClass(Ticket.class)
	            		.buildSessionFactory();
	            
	        } catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
	    
	    public static Session getSesssion()
	    {
	    	return getSessionFactory().openSession(); //Session opened
	    }

			    }