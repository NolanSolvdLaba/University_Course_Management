package org.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.dao.StudentMapper;
import org.example.model.Student;
import org.example.service.StudentService;
import org.example.util.MyBatisUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        // Create a SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            StudentService studentService = new StudentService(studentMapper);

            // Create a new student
            Student student = new Student("John Doe", 2022, 1, "Computer Science");
            studentService.create(student);
            System.out.println("Created student: " + student);

            // Get student by ID
            int studentId = 4;
            Student fetchedStudent = studentService.getById(studentId);
            System.out.println("Fetched student by ID " + studentId + ": " + fetchedStudent);

            // Delete student
            int studentToDeleteId = 2;
            studentService.delete(studentToDeleteId);
            System.out.println("Deleted student with ID " + studentToDeleteId);

            // Get all students
            List<Student> students = studentService.getAll();
            System.out.println("All students: ");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }
}
