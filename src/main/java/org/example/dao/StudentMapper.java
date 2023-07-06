package org.example.dao;

import org.example.model.Student;

import java.util.List;

public interface StudentMapper {

    void create(Student student);

    Student getById(int id);

    void update(Student student);

    void delete(int id);

    List<Student> getAll();

}
