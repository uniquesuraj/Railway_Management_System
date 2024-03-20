package com.suraj.Railway;

import java.util.Scanner;
import com.suraj.model.Ticket;
import com.suraj.service.TicketService;
import com.suraj.serviceimpl.TicketServiceImpl;

import com.suraj.daoimp.TicketDaoImpl;


public class TicketClient {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TicketService ticketService = new TicketServiceImpl(new TicketDaoImpl());

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Create Ticket");
            System.out.println("2. Get Ticket");
            System.out.println("3. Update Ticket");
            System.out.println("4. Delete Ticket");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    createTicket();
                    break;
                case 2:
                    readTicket();
                    break;
                case 3:
                    updateTicket();
                    break;
                case 4:
                    deleteTicket();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void createTicket() {
        System.out.print("Enter ticket ID: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter user ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter train ID: ");
        int trainId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        Ticket ticket = new Ticket(ticketId, userId, trainId);
        ticketService.createTicket(ticket);
        System.out.println("Ticket created successfully!");
    }

    private static void readTicket() {
        System.out.print("Enter ticket ID to read details: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        Ticket ticket = ticketService.getTicket(ticketId);
        if (ticket != null) {
            System.out.println("Ticket details:");
            System.out.println("ID: " + ticket.getTicketid());
            System.out.println("User ID: " + ticket.getUserid());
            System.out.println("Train ID: " + ticket.getTrainid());
        } else {
            System.out.println("Ticket with ID " + ticketId + " not found.");
        }
    }

    private static void updateTicket() {
        System.out.print("Enter ticket ID to update details: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        Ticket existingTicket = ticketService.getTicket(ticketId);
        if (existingTicket != null) {
            System.out.println("Enter new details:");
            System.out.print("New user ID: ");
            int newUserId = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("New train ID: ");
            int newTrainId = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            existingTicket.setUserid(newUserId);
            existingTicket.setTrainid(newTrainId);
            
            ticketService.updateTicket(ticketId, existingTicket);
            System.out.println("Ticket details updated successfully!");
        } else {
            System.out.println("Ticket with ID " + ticketId + " not found.");
        }
    }

    private static void deleteTicket() {
        System.out.print("Enter ticket ID to delete: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        ticketService.deleteTicket(ticketId);
        System.out.println("Ticket with ID " + ticketId + " deleted successfully!");
    }
}

