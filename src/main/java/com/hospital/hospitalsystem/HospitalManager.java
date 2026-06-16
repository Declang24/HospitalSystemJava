package com.hospital.hospitalsystem;

import com.hospital.hospitalsystem.model.User;

import java.util.Scanner;

public class HospitalManager {

    private static final Scanner kb = new Scanner(System.in);

    public static void main(String [] args)
    {
        System.out.println("-- User Management System --\n");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");

        String choice = kb.nextLine();

        switch (choice)
        {
            case "1":
                System.out.println("Register user selected");
                register();
                break;
            case "2":
                System.out.println("Login user selected");
                break;
            case "3":
                System.out.println("Exit selected, goodbye!");
                return;
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void register()
    {
        //Enter name
        System.out.print("Enter name: ");
        String name = kb.nextLine();

        //Enter age
        System.out.print("Enter age: ");
        int age = kb.nextInt();
        kb.nextLine();

        //Enter gender
        System.out.print("Enter gender (male/female):");
        String gender = kb.nextLine();

        //Enter role
        System.out.print("Enter role (patient/doctor):");
        String role = kb.nextLine();

        User user = new User(name, age, gender, role);
        System.out.println(user.toString());
    }
}
