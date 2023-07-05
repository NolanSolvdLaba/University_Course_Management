package org.example.dao;

import org.example.model.Classroom;

import java.util.List;

public interface ClassroomMapper {
    void create(Classroom classroom);

    Classroom getById(int id);

    void update(Classroom classroom);

    void delete(int id);

    List<Classroom> getAll();
}
