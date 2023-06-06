package org.example.dao;

import org.example.model.Course;
import org.example.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    public void create(Course course) {
        String query = "INSERT INTO course (course_name, credits, semester_id, instructor_id, department_id, classroom_id, description) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course.getCourseName());
            statement.setInt(2, course.getCredits());
            statement.setInt(3, course.getSemesterId());
            statement.setInt(4, course.getInstructorId());
            statement.setInt(5, course.getDepartmentId());
            statement.setInt(6, course.getClassroomId());
            statement.setString(7, course.getDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Course getById(int id) {
        String query = "SELECT * FROM course WHERE course_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String courseName = resultSet.getString("course_name");
                int credits = resultSet.getInt("credits");
                int semesterId = resultSet.getInt("semester_id");
                int instructorId = resultSet.getInt("instructor_id");
                int departmentId = resultSet.getInt("department_id");
                int classroomId = resultSet.getInt("classroom_id");
                String description = resultSet.getString("description");
                return new Course(id, courseName, credits, semesterId, instructorId, departmentId, classroomId, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Course course) {
        String sql = "UPDATE course SET course_name = ?, credits = ?, semester_id = ?, instructor_id = ?, department_id = ?, classroom_id = ?, description = ? WHERE course_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, course.getCourseName());
            statement.setInt(2, course.getCredits());
            statement.setInt(3, course.getSemesterId());
            statement.setInt(4, course.getInstructorId());
            statement.setInt(5, course.getDepartmentId());
            statement.setInt(6, course.getClassroomId());
            statement.setString(7, course.getDescription());
            statement.setInt(8, course.getCourseId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM course WHERE course_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM course";
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                int credits = resultSet.getInt("credits");
                int semesterId = resultSet.getInt("semester_id");
                int instructorId = resultSet.getInt("instructor_id");
                int departmentId = resultSet.getInt("department_id");
                int classroomId = resultSet.getInt("classroom_id");
                String description = resultSet.getString("description");
                courses.add(new Course(id, courseName, credits, semesterId, instructorId, departmentId, classroomId, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
