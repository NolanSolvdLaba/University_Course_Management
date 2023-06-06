package org.example.service;

import org.example.dao.StudentDAO;
import org.example.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public void create(Student student) {
        if (studentDAO.getByName(student.getStudentName()) == null) {
            studentDAO.create(student);
        } else {
            System.out.println("Student already exists: " + student.getStudentName());
        }
    }

    public Student getById(int id) {
        return studentDAO.getById(id);
    }

    public void update(Student student) {
        studentDAO.update(student);
    }

    public void delete(int id) {
        studentDAO.delete(id);
    }

    public List<Student> getAll() {
        return studentDAO.getAll();
    }
}
