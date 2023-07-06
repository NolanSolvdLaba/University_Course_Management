package org.example.service;

import org.example.dao.StudentMapper;
import org.example.model.Student;

import java.util.List;

public class StudentService {
    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public void create(Student student) {
        if (studentMapper.getById(student.getStudentId()) == null) {
            studentMapper.create(student);
        } else {
            System.out.println("Student already exists: " + student.getStudentName());
        }
    }


    public void update(Student student) {
        studentMapper.update(student);
    }

    public void delete(int id) {
        studentMapper.delete(id);
    }

    public List<Student> getAll() {
        return studentMapper.getAll();
    }

    public Student getById(int studentId) {
        return studentMapper.getById(studentId);
    }

}
