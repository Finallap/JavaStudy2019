package com.bean;

/**
 * @description: Student
 * @date: 2020/4/25 21:58
 * @author: Finallap
 * @version: 1.0
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private String password;
    private boolean receivePaper;
    private String[] favoriteFramework;
    private String gender;
    private String favoriteNumber;
    private String country;

    public Student() {
        receivePaper = true;
    }

    public Student(int id, String name, int age, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isReceivePaper() {
        return receivePaper;
    }

    public void setReceivePaper(boolean receivePaper) {
        this.receivePaper = receivePaper;
    }

    public String[] getFavoriteFramework() {
        return favoriteFramework;
    }

    public void setFavoriteFramework(String[] favoriteFramework) {
        this.favoriteFramework = favoriteFramework;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(String favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
