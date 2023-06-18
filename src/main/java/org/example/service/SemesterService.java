package org.example.service;

import org.example.dao.SemesterDAO;
import org.example.model.Semester;

import java.util.List;

public class SemesterService implements GenericService<Semester> {

    private final SemesterDAO semesterDAO;

    public SemesterService() {
        this.semesterDAO = new SemesterDAO();
    }

    @Override
    public void create(Semester semester) {
        semesterDAO.create(semester);
    }

    @Override
    public Semester getById(int id) {
        return semesterDAO.getById(id);
    }

    @Override
    public void update(Semester semester) {
        semesterDAO.update(semester);
    }

    @Override
    public void delete(int id) {
        semesterDAO.delete(id);
    }

    @Override
    public List<Semester> getAll() {
        return semesterDAO.getAll();
    }
}
