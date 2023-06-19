package org.example;

import org.example.model.Instructor;
import org.example.model.Department;
import org.example.service.InstructorService;
import org.example.service.DepartmentService;
import org.example.util.ConnectionPool;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Nolan\\IdeaProjects\\University_Course_Management\\src\\main\\resources\\course\\course.xml"));

            Element root = document.getDocumentElement();
            NodeList courseList = root.getElementsByTagName("course");

            Connection connection = ConnectionPool.getConnection();

            for (int i = 0; i < courseList.getLength(); i++) {
                Element courseElement = (Element) courseList.item(i);
                String courseName = courseElement.getElementsByTagName("course_name").item(0).getTextContent();
                int credits = Integer.parseInt(courseElement.getElementsByTagName("credits").item(0).getTextContent());
                int semesterId = Integer.parseInt(courseElement.getElementsByTagName("semester_id").item(0).getTextContent());
                int instructorId = Integer.parseInt(courseElement.getElementsByTagName("instructor_id").item(0).getTextContent());
                int classroomId = Integer.parseInt(courseElement.getElementsByTagName("classroom_id").item(0).getTextContent());
                String description = courseElement.getElementsByTagName("description").item(0).getTextContent();

                PreparedStatement statement = connection.prepareStatement("INSERT INTO course (course_name, credits, semester_id, instructor_id, classroom_id, description) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, courseName);
                statement.setInt(2, credits);
                statement.setInt(3, semesterId);
                statement.setInt(4, instructorId);
                statement.setInt(5, classroomId);
                statement.setString(6, description);
                statement.executeUpdate();
                statement.close();
            }

            connection.close();

            // Instantiate the InstructorService and DepartmentService
            InstructorService instructorService = new InstructorService();
            DepartmentService departmentService = new DepartmentService();

            // Create a new instructor
            Instructor instructor = new Instructor("John Doe");
            instructorService.create(instructor);
            System.out.println("Created instructor: " + instructor);

            // Get instructor by ID
            int instructorId = instructor.getInstructorId();
            Instructor retrievedInstructor = instructorService.getById(instructorId);
            System.out.println("Retrieved instructor: " + retrievedInstructor);

            // Update instructor
            retrievedInstructor.setInstructorName("Jane Smith");
            instructorService.update(retrievedInstructor);
            System.out.println("Updated instructor: " + retrievedInstructor);

            // Delete instructor
            instructorService.delete(instructorId);
            System.out.println("Instructor deleted.");

            // Get all instructors
            List<Instructor> allInstructors = instructorService.getAll();
            System.out.println("All instructors:");
            for (Instructor inst : allInstructors) {
                System.out.println(inst);
            }

            // Create a new department
            Department department = new Department("Computer Science");
            departmentService.create(department);
            System.out.println("Created department: " + department);

            // Get department by name
            Department retrievedDepartment = departmentService.getByName(department.getDepartmentName());
            System.out.println("Retrieved department: " + retrievedDepartment);

            // Update department
            retrievedDepartment.setDepartmentName("Information Technology");
            departmentService.update(retrievedDepartment);
            System.out.println("Updated department: " + retrievedDepartment);

            // Delete department
            departmentService.delete(retrievedDepartment.getDepartmentName());
            System.out.println("Department deleted.");

            // Get all departments
            List<Department> allDepartments = departmentService.getAll();
            System.out.println("All departments:");
            for (Department dept : allDepartments) {
                System.out.println(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
