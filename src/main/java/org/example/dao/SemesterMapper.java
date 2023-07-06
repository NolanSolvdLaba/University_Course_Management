package org.example.dao;

import org.example.model.Semester;

import java.util.List;

public interface SemesterMapper {
    void create(Semester semester);
    Semester getById(int id);
    void update(Semester semester);
    void delete(int id);
    List<Semester> getAll();
}
