package com.suraj.daoimp;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.suraj.dao.TicketDao;
import com.suraj.model.Ticket;
import com.suraj.utility.HibernateUtil;

public class TicketDaoImpl implements TicketDao {

    @Override
    public Ticket createTicket(Ticket ticket) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(ticket);
            session.getTransaction().commit();
            return ticket;
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Ticket> getAllTickets() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Ticket", Ticket.class).list();
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ticket getTicket(int ticketId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Ticket.class, ticketId);
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Ticket updateTicket(int ticketId, Ticket ticket) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Ticket existingTicket = session.get(Ticket.class, ticketId);
            if (existingTicket != null) {
                existingTicket.setUserid(ticket.getUserid());
                existingTicket.setTrainid(ticket.getTrainid());
                // set other fields as needed
                existingTicket.setTicketid(ticket.getTicketid()); // Setting ticket id
                session.update(existingTicket);
                session.getTransaction().commit();
                return existingTicket;
            }
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public String deleteTicket(int ticketId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, ticketId);
            if (ticket != null) {
                session.delete(ticket);
                session.getTransaction().commit();
                return "Ticket deleted successfully.";
            }
        } catch (HibernateException e) {
            System.out.println(e);
        }
        return "Failed to delete ticket.";
    }
}
