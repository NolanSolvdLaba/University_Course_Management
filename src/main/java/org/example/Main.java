package org.example;

import org.example.model.Student;
import org.example.model.Course;
import org.example.service.StudentService;
import org.example.service.CourseService;
import org.example.util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Get connection from the connection pool
            Connection connection = ConnectionPool.getConnection();

            // New instances of StudentService and CourseService
            StudentService studentService = new StudentService();
            CourseService courseService = new CourseService();

            // Create new student
            Student student = new Student("Tony Soprano", 2022, 2, "Philosophy");
            studentService.create(student);

            // Get student by ID
            Student retrievedStudent = studentService.getById(5);
            System.out.println("Retrieved student: " + retrievedStudent);

            // Update student
            retrievedStudent.setStudentName("Henry Hill");
            studentService.update(retrievedStudent);

            // Delete student
            studentService.delete(3);

            // Get all students
            List<Student> allStudents = studentService.getAll();
            System.out.println("All students: " + allStudents);

            // Create new course
            Course course = new Course("Introduction to Programming", 3, 1, 1, 1, 1, "An introductory course on programming");
            courseService.create(course);

            // Get course by ID
            Course retrievedCourse = courseService.getById(1);
            System.out.println("Retrieved course: " + retrievedCourse);

            // Update course
            retrievedCourse.setCourseName("Advanced Programming");
            courseService.update(retrievedCourse);

            // Delete course
            courseService.delete(2);

            // Get all courses
            List<Course> allCourses = courseService.getAll();
            System.out.println("All courses: " + allCourses);

            // Close connection
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
