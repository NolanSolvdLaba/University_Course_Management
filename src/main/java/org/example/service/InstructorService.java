package org.example.service;

import org.example.dao.InstructorDAO;
import org.example.model.Instructor;

import java.util.List;

public class InstructorService {
    private final InstructorDAO instructorDAO;

    public InstructorService() {
        this.instructorDAO = new InstructorDAO();
    }

    public void create(Instructor instructor) {
        instructorDAO.create(instructor);
    }

    public Instructor getById(int id) {
        return instructorDAO.getById(id);
    }

    public void update(Instructor instructor) {
        instructorDAO.update(instructor);
    }

    public void delete(int id) {
        instructorDAO.delete(id);
    }

    public List<Instructor> getAll() {
        return instructorDAO.getAll();
    }
}
