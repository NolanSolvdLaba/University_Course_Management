package org.example.service;

import org.example.dao.CourseMapper;
import org.example.model.Course;

import java.util.List;

public class CourseService {
    private final CourseMapper courseMapper;

    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public void create(Course course) {
        courseMapper.create(course);
    }

    public Course getById(int id) {
        return courseMapper.getById(id);
    }

    public void update(Course course) {
        courseMapper.update(course);
    }

    public void delete(int id) {
        courseMapper.delete(id);
    }

    public List<Course> getAll() {
        return courseMapper.getAll();
    }
}
