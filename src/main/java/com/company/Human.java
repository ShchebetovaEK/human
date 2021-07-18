package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Human implements Serializable {


     private String FirstName;
     private String LastName;
     private int age;
     private Sex sex;

    public Human(String firstName, String lastName, int age, Sex sex) {
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Human{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
