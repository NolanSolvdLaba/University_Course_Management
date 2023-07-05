package org.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.dao.CourseMapper;
import org.example.model.Course;
import org.example.service.CourseService;
import org.example.util.MyBatisUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        // Create a SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            // Create instances of the service classes
            CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
            CourseService courseService = new CourseService(courseMapper);

            // Create a new course
            Course course = new Course("Calc", 4, 1, 1, 1, 1, "Introduction to Mathematics");
            courseService.create(course);
            System.out.println("Created course: " + course);

            // Get course by ID
            int courseId = 1;
            Course fetchedCourse = courseService.getById(courseId);
            System.out.println("Fetched course by ID " + courseId + ": " + fetchedCourse);

            // Delete course
            int courseToDeleteId = 2;
            courseService.delete(courseToDeleteId);
            System.out.println("Deleted course with ID " + courseToDeleteId);

            // Get all courses
            List<Course> courses = courseService.getAll();
            System.out.println("All courses: ");
            for (Course c : courses) {
                System.out.println(c);
            }

            }
        }
    }

