package org.example.service;

import org.example.dao.SemesterMapper;
import org.example.model.Semester;

import java.sql.ResultSet;
import java.util.List;

public class SemesterService  {

    private final SemesterMapper semesterMapper;

    public SemesterService(SemesterMapper semesterMapper) {
        this.semesterMapper = semesterMapper;
    }

    public void create(Semester semester) {
        semesterMapper.create(semester);
    }

    public Semester getById(int id) {
        return semesterMapper.getById(id);
    }

    public void update(Semester semester) {
        semesterMapper.update(semester);
    }

    public void delete(int id) {
        semesterMapper.delete(id);
    }

    public List<Semester> getAll() {
        return semesterMapper.getAll();
    }
}
