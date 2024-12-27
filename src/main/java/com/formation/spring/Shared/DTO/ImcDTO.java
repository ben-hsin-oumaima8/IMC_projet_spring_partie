package com.formation.spring.Shared.DTO;

public class ImcDTO {
    private String userId;
    private int age;


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getBmiClassification() {
        return bmiClassification;
    }

    public void setBmiClassification(String bmiClassification) {
        this.bmiClassification = bmiClassification;
    }

    private double weight;
    private double height;
    private String gender;
    private double bmi;
    private String bmiClassification;

    // Getters and Setters
    // Add all getters and setters for the above fields
}