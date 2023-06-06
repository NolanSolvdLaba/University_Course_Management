package org.example.service;

import org.example.dao.StudentDAO;
import org.example.model.Student;

import java.util.List;

public class StudentService implements GenericService<Student>{
        private final StudentDAO studentDAO;

        public StudentService() {
            this.studentDAO = new StudentDAO();
        }

        @Override
        public void create(Student student) {
            studentDAO.create(student);
        }

        @Override
        public Student getById(int id) {
            return studentDAO.getById(id);
        }

        @Override
        public void update(Student student) {
            studentDAO.update(student);
        }

        @Override
        public void delete(int id) {
            studentDAO.delete(id);
        }

        @Override
        public List<Student> getAll() {
            return studentDAO.getAll();
        }
    }




