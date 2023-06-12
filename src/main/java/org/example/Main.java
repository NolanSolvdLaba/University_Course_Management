package org.example;

import org.example.util.ConnectionPool;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
                int departmentId = Integer.parseInt(courseElement.getElementsByTagName("department_id").item(0).getTextContent());
                int classroomId = Integer.parseInt(courseElement.getElementsByTagName("classroom_id").item(0).getTextContent());
                String description = courseElement.getElementsByTagName("description").item(0).getTextContent();

                PreparedStatement statement = connection.prepareStatement("INSERT INTO course (course_name, credits, semester_id, instructor_id, department_id, classroom_id, description) VALUES (?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1, courseName);
                statement.setInt(2, credits);
                statement.setInt(3, semesterId);
                statement.setInt(4, instructorId);
                statement.setInt(5, departmentId);
                statement.setInt(6, classroomId);
                statement.setString(7, description);
                statement.executeUpdate();
                statement.close();
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
