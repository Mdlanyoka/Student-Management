
import javax.swing.JTable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Admin
 */


// This is an interface called "Manageable".

interface Manageable {
// Method to add a new student with the given details.
void add(int studentID, String name, int age, int grade); // Method to remove a student with the specified studentID.
void remove(String studentID);

// Method to display all students in a JTable.
void displayAll(JTable table);
}