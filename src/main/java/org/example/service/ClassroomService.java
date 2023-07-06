package org.example.service;

import org.example.dao.ClassroomMapper;
import org.example.model.Classroom;

import java.util.List;

public class ClassroomService {
    private final ClassroomMapper classroomMapper;

    public ClassroomService(ClassroomMapper classroomMapper) {
        this.classroomMapper = classroomMapper;
    }

    public void create(Classroom classroom) {
        classroomMapper.create(classroom);
    }

    public Classroom getById(int id) {
        return classroomMapper.getById(id);
    }

    public void update(Classroom classroom) {
        classroomMapper.update(classroom);
    }

    public void delete(int id) {
        classroomMapper.delete(id);
    }

    public List<Classroom> getAll() {
        return classroomMapper.getAll();
    }
}
