package com.suraj.daoimp;

import com.suraj.dao.TrainDao;
import com.suraj.model.Train;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.suraj.utility.HibernateUtil;

public class TrainDaoImpl implements TrainDao {
	
	 @Override
	    public Train createTrain(Train train) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            session.beginTransaction();
	            session.save(train);
	            session.getTransaction().commit();
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
    @Override
    public Train getTrain(int trainId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Train.class, trainId);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Train updateTrain(int trainId, Train train) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Train existingTrain = session.get(Train.class, trainId);
            if (existingTrain != null) {
                existingTrain.setTrainname(train.getTrainname());
                existingTrain.setDeparture(train.getDeparture());
                existingTrain.setArrival(train.getArrival());
                // set other fields as needed
                
                session.update(existingTrain);
                session.getTransaction().commit();
                return existingTrain;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Train deleteTrain(int trainId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Train train = session.get(Train.class, trainId);
            if (train != null) {
                session.delete(train);
                session.getTransaction().commit();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

   
    
}
	

	


		


	