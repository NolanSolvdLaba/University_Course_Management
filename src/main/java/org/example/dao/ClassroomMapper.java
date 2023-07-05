package org.example.dao;

import org.example.model.Classroom;

import java.util.List;
public interface ClassroomMapper {
    Classroom getById(int id);
    void create(Classroom classroom);
    void update(Classroom classroom);
    void delete(int id);
    List<Classroom> getAll();
}
