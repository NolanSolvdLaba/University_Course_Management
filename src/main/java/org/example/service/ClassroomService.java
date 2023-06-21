package org.example.service;

import org.example.dao.ClassroomDAO;
import org.example.model.Classroom;

import java.util.List;

public class ClassroomService {

    private final ClassroomDAO classroomDAO;

    public ClassroomService() {
        this.classroomDAO = new ClassroomDAO();
    }

    public void create(Classroom classroom) {
        classroomDAO.create(classroom);
    }

    public Classroom getById(int id) {
        return classroomDAO.getById(id);
    }

    public void update(Classroom classroom) {
        classroomDAO.update(classroom);
    }

    public void delete(int id) {
        classroomDAO.delete(id);
    }

    public List<Classroom> getAll() {
        return classroomDAO.getAll();
    }
}
