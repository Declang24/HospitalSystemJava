package com.hospital.hospitalsystem.model;

public class User {
    private static int id;
    private String name;
    private int age;
    private String gender;
    private String role;

    public User(String name, int age, String gender, String role)
    {
        id += 1;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public String getName() {
        return name;
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
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
