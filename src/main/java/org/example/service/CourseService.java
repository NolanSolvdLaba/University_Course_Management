package org.example.service;

import org.example.dao.CourseMapper;
import org.example.model.Course;

import java.util.List;

public class CourseService {
    private final CourseMapper courseDAO;

    public CourseService(CourseMapper courseDAO) {
        this.courseDAO = courseDAO;
    }

    public void create(Course course) {
        courseDAO.create(course);
    }

    public Course getById(int id) {
        return courseDAO.getById(id);
    }

    public void update(Course course) {
        courseDAO.update(course);
    }

    public void delete(int id) {
        courseDAO.delete(id);
    }

    public List<Course> getAll() {
        return courseDAO.getAll();
    }
}
