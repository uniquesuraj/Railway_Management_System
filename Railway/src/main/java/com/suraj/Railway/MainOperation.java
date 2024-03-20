package com.suraj.Railway;

import java.util.Scanner;

import com.suraj.Railway.App;
import com.suraj.Railway.TicketClient;
import com.suraj.Railway.TrainClient;

public class MainOperation {

	 private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("Main Menu:");
	            System.out.println("1. User Management");
	            System.out.println("2. Train Management");
	            System.out.println("3. Ticket Management");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (choice) {
	                case 1:
	                    UserManagement();
	                    break;
	                case 2:
	                    TrainManagement();
	                    break;
	                case 3:
	                    TicketManagement();
	                    break;
	                case 4:
	                    exit = true;
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please enter a valid option.");
	            }
	        }
	    }

	    private static void UserManagement() {
	        System.out.println("User Management Menu:");
	        System.out.println("1. User Operations");
	        System.out.println("2. Back to Main Menu");
	        System.out.print("Enter your choice: ");

	        int choice = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character

	        switch (choice) {
	            case 1:
	                App.main(null); // Launch User Management
	                break;
	            case 2:
	                return;
	            default:
	                System.out.println("Invalid choice! Please enter a valid option.");
	        }
	    }

	    private static void TrainManagement() {
	        System.out.println("Train Management Menu:");
	        System.out.println("1. Train Operations");
	        System.out.println("2. Back to Main Menu");
	        System.out.print("Enter your choice: ");

	        int choice = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character

	        switch (choice) {
	            case 1:
	            	TrainClient.main(null); //  Ticket Management
	                break;
	            case 2:
	                return;
	            default:
	                System.out.println("Invalid choice! Please enter a valid option.");
	        }
	    }

	    private static void TicketManagement() {
	        System.out.println("Ticket Management Menu:");
	        System.out.println("1. Ticket Operations");
	        System.out.println("2. Back to Main Menu");
	        System.out.print("Enter your choice: ");

	        int choice = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character

	        switch (choice) {
	            case 1:
	            	TicketClient.main(null); 
	                break;
	            case 2:
	                return;
	            default:
	                System.out.println("Invalid choice! Please enter a valid option.");
	        }
	    }
}