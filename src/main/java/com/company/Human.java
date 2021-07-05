package com.company;

public class Human {

    String FirstName;
    String SecondName;
    int age;
    Sex sex;

    public Human(String firstName, String secondName, int age) {
        FirstName = firstName;
        SecondName = secondName;
        this.age = age;
    }

    public Human(String firstName, String secondName, int age, Sex sex) {
        FirstName = firstName;
        SecondName = secondName;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
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
                ", SecondName='" + SecondName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
