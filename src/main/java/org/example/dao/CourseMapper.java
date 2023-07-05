package org.example.dao;

import org.example.model.Course;

import java.util.List;
public interface CourseMapper {

    void create(Course course);

    Course getById(int id);

    void update(Course course);

    void delete(int id);

    public abstract List<Course> getAll();
}
