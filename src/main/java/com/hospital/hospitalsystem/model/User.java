package com.hospital.hospitalsystem.model;

import java.util.InputMismatchException;
import java.util.Scanner;

//Utility Classes
import com.hospital.hospitalsystem.service.DatabaseOperationsService;
import com.hospital.hospitalsystem.service.LoginService;
import com.hospital.hospitalsystem.service.ValidationService;

public class User {
    private static int id;
    private String name;
    private String email;
    private int age;
    private String gender;
    private String role;

    private static final Scanner scanner = new Scanner(System.in);
    private static int idSearch; //For Find by user ID

    public User(String name, String email, int age, String gender, String role)
    {
        id += 1;
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    //Add patient - Add patient with NAME, AGE, GENDER, ROLE
    public static void register()
    {
        //Enter first name
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        if(!ValidationService.isValidName(firstName)){
            System.out.println("Invalid name, must not contain numbers or spaces.");
            return;
        }

        //Enter last name
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        if(!ValidationService.isValidName(lastName)) {
            System.out.println("Invalid name, must not contain numbers or spaces.");
            return;
        }

        String name = firstName + " " + lastName;

        //Enter email
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        if(!ValidationService.isValidEmail(email)){
            System.out.println("Invalid email.");
            return;
        }


        //Enter age
        int age = 1;
        System.out.print("Enter age: ");
        try {
            age = scanner.nextInt();
            scanner.nextLine();

            //Valid age check - If these conditions are violated, return error message and send back to menu
            if(!ValidationService.isValidAge(age)) {
                System.out.println("Invalid age.");
                return;
            }
        }
        catch (InputMismatchException e) {
                System.out.println("Invalid age, please enter a numerical value.");
                return;
            }


        //Enter gender
        System.out.print("Enter gender (male/female): ");
        String gender = scanner.nextLine();
        if(!ValidationService.isValidGender(gender)){
            System.out.println("Invalid gender, please input one of the two options displayed.");
            return;
        }

        //Enter role
        System.out.print("Enter role (patient/doctor): ");
        String role = scanner.nextLine();
        if(!ValidationService.isValidRole(role)){
            System.out.println("Invalid role, please input one of the two options displayed.");
            return;
        }

        User user = new User(name, email, age, gender, role);
        LoginService.registerUser(user);
        //System.out.println(user.toString());
    }

    //GetID - Specifically for 'Search by ID option' on menu
    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail(){
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email=" + email + '\'' +
                ", age=" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
