package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.model.Classroom;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            //new classroom instance
            Classroom classroom = new Classroom(11, "A101", 30);

            //instance of object mapper
            ObjectMapper objectMapper = new ObjectMapper();

            //print nicely
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            //write to file
            objectMapper.writeValue(new File("src/main/resources/JSONfiles/classroom.json"), classroom);
            System.out.println("JSON file created");
        } catch (IOException e) {
             e.printStackTrace();
        }


//        try {
//            Classroom classroom = new Classroom(10, "101", 30);
//
//            File file = new File("src/main/resources/jaxbFiles/classroom.xml");
//
//            JAXBContext jaxbContext = JAXBContext.newInstance(Classroom.class);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(classroom, file);
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

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

//        try {
//            File file = new File("src/main/resources/jaxbFiles/grade.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(Grades.class);
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            Grades grade = (Grades) jaxbUnmarshaller.unmarshal(file);
//
//            //Accessing the parsed object
//            System.out.println("Grade ID: " + grade.getGradeId());
//            System.out.println("Enrollment ID: " + grade.getEnrollmentId());
//            System.out.println("Grade: " + grade.getGrade());
//            System.out.println("Course ID: " + grade.getCourseId());
//            System.out.println("Student ID: " + grade.getStudentId());
//
//        } catch (JAXBException e){
//            e.printStackTrace();
//        }


    }
}
