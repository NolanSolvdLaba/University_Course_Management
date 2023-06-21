package org.example;

import org.example.model.Department;
import org.example.model.jaxb.Grades;
import org.example.service.DepartmentService;
import org.example.util.ConnectionPool;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try {
//            Grades grade = new Grades(20, 10, "97", 1, 1);
//
//            File file = new File("src/main/resources/jaxbFiles/grade.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(Grades.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.marshal(grade, file);
//            jaxbMarshaller.marshal(grade, System.out);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        try {
            File file = new File("src/main/resources/jaxbFiles/grade.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Grades.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Grades grade = (Grades) jaxbUnmarshaller.unmarshal(file);

            //Accessing the parsed object
            System.out.println("Grade ID: " + grade.getGradeId());
            System.out.println("Enrollment ID: " + grade.getEnrollmentId());
            System.out.println("Grade: " + grade.getGrade());
            System.out.println("Course ID: " + grade.getCourseId());
            System.out.println("Student ID: " + grade.getStudentId());

        } catch (JAXBException e){
            e.printStackTrace();
        }
    }
}
