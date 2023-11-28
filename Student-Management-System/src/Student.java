/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */

// This is a class definition for a Student.

class Student {
private int studentID; // Private variable to store the student ID.
private String name; // Private variable to store the student's name.
private int age; // Private variable to store the student's age.
private int grade; // Private variable to store the student's grade.
// Constructor for the Student class.
// It initializes the instance variables with the provided values.
public Student(int studentID, String name, int age, int grade) {
    this.studentID = studentID;
    this.name = name;
    this.age = age;
    this.grade = grade;
}

// Getters and setters for the private variables.

// Getter method for retrieving the student's ID.
public int getStudentID() {
    return studentID;
}

// Setter method for setting the student's ID.
public void setStudentID(int studentID) {
    this.studentID = studentID;
}

// Getter method for retrieving the student's name.
public String getName() {
    return name;
}

// Setter method for setting the student's name.
public void setName(String name) {
    this.name = name;
}

// Getter method for retrieving the student's age.
public int getAge() {
    return age;
}

// Setter method for setting the student's age.
public void setAge(int age) {
    this.age = age;
}

// Getter method for retrieving the student's grade.
public int getGrade() {
    return grade;
}

// Setter method for setting the student's grade.
public void setGrade(int grade) {
    this.grade = grade;
}
}