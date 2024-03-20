package com.suraj.Railway;

import java.util.Scanner;


import com.suraj.model.User;
import com.suraj.service.UserService;

import com.suraj.serviceimpl.UserServiceImpl;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Create User");
            System.out.println("2. Read User");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    readUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }

    private static void createUser() {
        System.out.print("Enter user ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user phone number: ");
        String phone = scanner.nextLine();
        
        User user = new User(id, name, phone);
        userService.createUser(user);
        System.out.println("User created successfully!");
        System.out.println("Inserted user details: " + user);
    }

    private static void readUser() {
    	 System.out.print("Enter user ID to read details: ");
    	    int userId = scanner.nextInt();
    	    scanner.nextLine(); // Consume newline character
    	    
    	    User user = userService.getUser(userId);
    	    if (user != null) {
    	        System.out.println("User details:");
    	        System.out.println("ID: " + user.getUserid());
    	        System.out.println("Name: " + user.getName());
    	        System.out.println("Phone: " + user.getPhone());
    	    } else {
    	        System.out.println("User with ID " + userId + " not found.");
    	    }
    }

    private static void updateUser() {
    	System.out.print("Enter user ID to update details: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        User existingUser = userService.getUser(userId);
        if (existingUser != null) {
            System.out.println("Enter new details:");
           System.out.print("Name: ");
            String newName = scanner.nextLine();
            System.out.print("Phone: ");
            String newPhone = scanner.nextLine();
            
            existingUser.setName(newName);
            existingUser.setPhone(newPhone);
            
            userService.updateUser(userId, existingUser);
            System.out.println("User details updated successfully!");
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    private static void deleteUser() {
    	System.out.print("Enter user ID to delete: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        
        String result = userService.deleteUser(userId);
        System.out.println(result);
  }
    
 }





