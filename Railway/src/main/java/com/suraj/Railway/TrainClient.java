package com.suraj.Railway;

import java.util.Scanner;

import com.suraj.daoimp.TrainDaoImpl;
import com.suraj.model.Train;
import com.suraj.service.TrainService;
import com.suraj.serviceimpl.TrainServiceImpl;



public class TrainClient {
	    private static final Scanner scanner = new Scanner(System.in);
	    private static final TrainService trainService = new TrainServiceImpl(new TrainDaoImpl());

	    public static void main(String[] args) {
	        boolean exit = false;

	        while (!exit) {
	            System.out.println("Menu:");
	            System.out.println("1. Create Train");
	            System.out.println("2. Get Train");
	            System.out.println("3. Update Train");
	            System.out.println("4. Delete Train");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character
	            
	            switch (choice) {
	            	case 1:
	            		createTrain();
	            		break;
	                case 2:
	                    readTrain();
	                    break;
	                case 3:
	                    updateTrain();
	                    break;
	                case 4:
	                    deleteTrain();
	                    break;
	                
	                case 5:
	                    exit = true;
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please enter a valid option.");
	            }
	        }
	    }

	    private static void createTrain() {
	        System.out.print("Enter train ID: ");
	        int trainId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character
	        System.out.print("Enter train name: ");
	        String trainName = scanner.nextLine();
	        System.out.print("Enter departure location: ");
	        String departure = scanner.nextLine();
	        System.out.print("Enter arrival location: ");
	        String arrival = scanner.nextLine();
	        
            Train train = new Train(trainId, trainName,departure, arrival);
            trainService.createTrain(train);
            System.out.println("Train created successfully!");
            System.out.println("Inserted train details: " + train);
	    }
	    
	    private static void readTrain() {
	        System.out.print("Enter train Id to read details: ");
	        int trainId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character
	        
	        Train train = trainService.getTrain(trainId);
	        if (train != null) {
	            System.out.println("Train details:");
	            System.out.println("ID: " + train.getTrainid());
	            System.out.println("Name: " + train.getTrainname());
	            System.out.println("Departure: " + train.getDeparture());
	            System.out.println("Arrival: " + train.getArrival());
	        } else {
	            System.out.println("Train with ID " + trainId + " not found.");
	        }
	    }

	    private static void updateTrain() {
	        System.out.print("Enter train id to update details: ");
	        int trainId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character
	        
	        Train existingTrain = trainService.getTrain(trainId);
	        if (existingTrain != null) {
	            System.out.println("Enter new details:");
	            System.out.print("Name: ");
	            String newName = scanner.nextLine();
	            System.out.print("Departure: ");
	            String newDeparture = scanner.nextLine();
	            System.out.print("Arrival: ");
	            String newArrival = scanner.nextLine();
	            
	            existingTrain.setTrainname(newName);
	            existingTrain.setDeparture(newDeparture);
	            existingTrain.setArrival(newArrival);
	            
	            trainService.updateTrain(trainId, existingTrain);
	            System.out.println("Train details updated successfully!");
	        } else {
	            System.out.println("Train with ID " + trainId + " not found.");
	        }
	    }

	    private static void deleteTrain() {
	        System.out.print("Enter train id to delete: ");
	        int trainId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character
	        
	        trainService.deleteTrain(trainId);
	        System.out.println("Train with ID " + trainId + " deleted successfully!");
	    }

	    
}
