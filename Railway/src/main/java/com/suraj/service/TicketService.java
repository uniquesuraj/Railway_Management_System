package com.suraj.service;

import java.util.List;
import com.suraj.model.Ticket;

public interface TicketService {

    Ticket createTicket(Ticket ticket);    
    List<Ticket> getAllTickets();
    Ticket getTicket(int ticketId);
    Ticket updateTicket(int ticketId, Ticket ticket);
    String deleteTicket(int ticketId);
}

