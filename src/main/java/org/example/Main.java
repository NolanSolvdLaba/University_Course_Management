package org.example;

import org.example.model.Student;
import org.example.model.Course;
import org.example.service.StudentService;
import org.example.service.CourseService;
import org.example.util.ConnectionPool;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Parse the XML file and retrieve the student data
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\Nolan\\IdeaProjects\\University_Course_Management\\src\\main\\resources\\student.xml"));

            Element root = document.getDocumentElement();
            NodeList studentList = root.getElementsByTagName("student");

            // Establish a connection to the MySQL database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/univcoursemgmt", "root", "password");

            // Iterate over the student data and insert/update records in the database
            for (int i = 0; i < studentList.getLength(); i++) {
                Element studentElement = (Element) studentList.item(i);
                String studentName = studentElement.getElementsByTagName("student_name").item(0).getTextContent();
                int admissionYear = Integer.parseInt(studentElement.getElementsByTagName("admission_year").item(0).getTextContent());
                int departmentId = Integer.parseInt(studentElement.getElementsByTagName("department_id").item(0).getTextContent());
                String departmentName = studentElement.getElementsByTagName("department_name").item(0).getTextContent();


                // Perform database operations (insert/update) based on your requirements
                // Use PreparedStatement to prevent SQL injection
                PreparedStatement statement = connection.prepareStatement("INSERT INTO student (student_name, admission_year, department_id, department_name) VALUES (?, ?, ?, ?)");
                statement.setString(1, studentName);
                statement.setInt(2, admissionYear);
                statement.setInt(3, departmentId);
                statement.setString(4, departmentName);
                statement.executeUpdate();
                statement.close();
            }

            // Close the database connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
