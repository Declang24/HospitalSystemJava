package com.hospital.hospitalsystem;

import com.hospital.hospitalsystem.model.User;
import com.hospital.hospitalsystem.service.DatabaseOperationsService;
import com.hospital.hospitalsystem.service.LoginService;

import java.util.Scanner;

public class HospitalManager {

    private static final Scanner kb = new Scanner(System.in);

    //Infinite while loop, exit condition is "7"
    public static void main(String[] args) {
        while(true) {
            System.out.println("\n-- User Management System --\n");
            System.out.println("1. Register Patient/Doctor");
            System.out.println("2. View All Users");
            System.out.println("3. View all Patients");
            System.out.println("4. View all doctors");
            System.out.println("5. View By ID");
            System.out.println("6. Delete by ID");
            System.out.println("7. Exit");

            String choice = kb.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Register user selected");
                    User.register();
                    break;
                case "2":
                    System.out.println("View all users selected");
                    DatabaseOperationsService.ListAllUsers();
                    break;
                case "3":
                    System.out.println("Listing all patients...");
                    DatabaseOperationsService.ListAllPatients();
                    break;
                case "4":
                    System.out.println("Listing all doctors...");
                    DatabaseOperationsService.ListAllDoctors();
                    break;
                case "5":
                    System.out.println("View user by ID selected");
                    DatabaseOperationsService.FindUserByID();
                    break;
                case "6":
                    System.out.println("Delete user by ID selected");
                    DatabaseOperationsService.RemoveUserByID();
                    break;
                case "7":
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}