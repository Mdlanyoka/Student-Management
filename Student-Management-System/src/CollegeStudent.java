/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class CollegeStudent extends Student implements Manageable {
    private String major;
    private final String dataFilename = "student_data.txt";
    private List<Student> studentList = new ArrayList<>();


    public CollegeStudent(int studentID, String name, int age, int grade, String major) {
        super(studentID, name, age, grade);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public boolean isStudentIDExists(int studentID) {
    try {
        List<String> lines = Files.readAllLines(Paths.get(dataFilename));
        for (String line : lines) {
            String[] attributes = line.split(",");
            if (attributes.length > 0 && attributes[0].equals(String.valueOf(studentID))) {
                return true;
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "An error occurred while reading student data: " + e.getMessage());
    }
    return false;
}

    @Override
    public void add(int studentID, String name, int age, int grade) {
        try {
            // Read all existing student data from the file
            List<String> lines = Files.readAllLines(Paths.get(dataFilename));

            // Check if the student ID already exists
            for (String line : lines) {
                String[] attributes = line.split(",");
                if (attributes.length > 0 && attributes[0].equals(String.valueOf(studentID))) {
                    JOptionPane.showMessageDialog(null, "Student ID already exists. Please choose a different one.");
                    return;
                }
            }

            // Create a new student object
            Student student = new CollegeStudent(studentID, name, age, grade, major);

            // Add the student to the studentList
            // Note: The studentList might be used elsewhere in the code
            // to perform additional operations on the students
            studentList.add(student);

            // Write the new student data to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilename, true))) {
                String studentData = studentID + "," + name + "," + age + "," + grade + "," + major;
                writer.write(studentData);
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Student added successfully.");
            } catch (IOException e) {
                System.out.println("Error writing student data to file: " + e.getMessage());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading student data: " + e.getMessage());
        }
    }

    @Override
    public void remove(String studentID) {
        try {
            // Read all existing student data from the file
            List<String> lines = Files.readAllLines(Paths.get(dataFilename));

            // Create a new list to store the updated student data
            List<String> updatedLines = new ArrayList<>();

            boolean found = false;

            // Iterate over each line of the student data
            for (String line : lines) {
                String[] attributes = line.split(",");
                if (attributes.length > 0 && attributes[0].equals(studentID)) {
                    found = true;
                    continue; // Skip the line with the matching student ID
                }
                updatedLines.add(line);
            }

            if (found) {
                // Ask for confirmation before removing the student
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this student?",
                        "Student Removal Confirmation", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    // Write the updated student data to the file
                    Files.write(Paths.get(dataFilename), updatedLines);
                    JOptionPane.showMessageDialog(null, "Student removed successfully.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Student was not found!");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading student data: " + e.getMessage());
        }
    }

    @Override
    public void displayAll(JTable table) {
        try {
            // Read all existing student data from the file
            List<String> lines = Files.readAllLines(Paths.get(dataFilename));

            // Create the table model to display the data in a JTable
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear previous data in the table

            // Populate the table model with student data
            for (String line : lines) {
                String[] attributes = line.split(",");
                if (attributes.length >= 4) {
                    String studentID = attributes[0];
                    String name = attributes[1];
                    int age = Integer.parseInt(attributes[2]);
                    int grade = Integer.parseInt(attributes[3]);
                    String major = ""; // Placeholder for major attribute

                    if (attributes.length >= 5) {
                        major = attributes[4];
                    }

                    // Add a new row to the table model
                    model.addRow(new Object[]{studentID, name, age, grade, major});
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading student data: " + e.getMessage());
        }
    }
}


