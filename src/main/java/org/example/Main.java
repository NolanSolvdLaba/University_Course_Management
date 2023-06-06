package org.example;

import org.example.model.Student;
import org.example.service.StudentService;
import org.example.util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Get a connection from the connection pool
            Connection connection = ConnectionPool.getConnection();

            // Create an instance of StudentService
            StudentService studentService = new StudentService();

            // Create a new student
            Student student = new Student("Tony Soprano", 2022, 2, "Philosophy");
            studentService.create(student);

            // Get a student by ID
            Student retrievedStudent = studentService.getById(5);
            System.out.println("Retrieved student: " + retrievedStudent);

            // Update a student
            retrievedStudent.setStudentName("Henry Hill");
            studentService.update(retrievedStudent);

            // Delete a student
            studentService.delete(3);

            // Get all students
            List<Student> allStudents = studentService.getAll();
            System.out.println("All students: " + allStudents);

            // Close the connection when you're done
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
