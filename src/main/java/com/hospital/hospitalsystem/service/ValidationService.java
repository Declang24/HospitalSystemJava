package com.hospital.hospitalsystem.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    static int maxAge = 130;

    public static boolean isValidName(String name)
    {
        String nameRegex = "([a-zA-Z]){2,32}"; //a-z, A-Z, between 2 and 20 chars
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches(); //Should return true if valid
    }

    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_.]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidAge(int age)
    {
        return age > 0 && age < maxAge;
    }

    public static boolean isValidGender(String gender)
    {
        gender = gender.toLowerCase(); //Ensures catching all cases
        return gender.equals("male") || gender.equals("female");
    }

    public static boolean isValidRole(String role)
    {
        role = role.toLowerCase();
        return role.equals("patient") || role.equals("doctor");
    }
}
