package com.hospital.hospitalsystem.model;

import java.util.function.Predicate;
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

    /*
    Add patient - Add patient with NAME, AGE, EMAIL, GENDER, ROLE - Designed so that the user will not be booted
    out with repeated incorrect inputs
    */
    public static void register()
    {
        String firstName;
        String lastName;
        String email;
        int age;
        String gender;
        String role;

        //Bool values for repeat valid input checks
        boolean validFName = false;
        boolean validLName = false;
        boolean validEmail = false;
        boolean validAge = false;
        boolean validGender = false;
        boolean validRole = false;

        //Reference variables for returning true/false values for inputs
        Predicate<String> isValidString =
                ValidationService::isValidName; //Same as str = ValidationService.isValidName(str)

        Predicate<String> isValidEmail =
                ValidationService::isValidEmail;

        Predicate<Integer> isValidAge =
                ValidationService::isValidAge;

        Predicate<String> isValidGender =
                ValidationService::isValidGender;

        Predicate<String> isValidRole =
                ValidationService::isValidRole;

        //Enter first name
        do {
            System.out.print("Enter first name: ");
            firstName = scanner.nextLine();
            validFName = isValidString.test(firstName);

            if(!validFName) {
                System.out.println("Invalid name, must not contain numbers or spaces " +
                        "and must be between 2-32 characters.");
            }

        }while(!validFName);


        //Enter last name
        do{
            System.out.print("Enter last name: ");
            lastName = scanner.nextLine();
            validLName = isValidString.test(lastName);

            if(!validLName) {
                System.out.println("Invalid name, must not contain numbers or spaces " +
                        "and must be between 2-32 characters.");
            }

        }while(!validLName);

        String name = firstName + " " + lastName;

        //Enter email
        do{
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            validEmail = isValidEmail.test(email);

            if(!validEmail) {
                System.out.println("Invalid email, must follow the structure of 'name@domain'" +
                        ", with top-level domain being 2-4 characters.");
            }

        }while(!validEmail);


        //Enter age
        do{
            System.out.print("Enter age: ");
            try {
                age = scanner.nextInt();
                scanner.nextLine();
                validAge = isValidAge.test(age);

                if(!validAge) {
                    System.out.println("Invalid age, please enter a numerical value between 1 and "
                            + ValidationService.getMaxAge());
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Error: Please enter a numerical value.");
                scanner.nextLine(); //Clear bad input, scanner will wait on this next loop
                age = -1; //Prevent infinite loop
            }

        }while(!validAge);


        //Enter gender
        do{

            System.out.print("Enter gender (male/female): ");
            gender = scanner.nextLine();
            validGender = isValidGender.test(gender);

            if(!validGender) {
                System.out.println("Invalid gender, please input one of the two options displayed.");
            }

        }while(!validGender);

        //Enter role
        do{

            System.out.print("Enter role (patient/doctor): ");
            role = scanner.nextLine();
            validRole = isValidRole.test(role);

            if(!validRole) {
                System.out.println("Invalid role, please input one of the two options displayed.");
            }

        }while(!validRole);

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
