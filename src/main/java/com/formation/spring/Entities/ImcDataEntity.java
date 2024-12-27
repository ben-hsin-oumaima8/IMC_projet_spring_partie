package com.formation.spring.Entities;

import javax.persistence.*;

@Entity(name = "ImcData")
public class ImcDataEntity {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private double weight;  // in kg

    @Column(nullable = false)
    private double height;  // in cm

    @Column(nullable = false, length = 10)
    private String gender;  // MALE/FEMALE

    @Column(nullable = false)
    private double bmi;

    @Column(nullable = false, length = 20)
    private String bmiClassification;




    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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


}