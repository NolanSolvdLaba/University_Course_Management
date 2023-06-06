package org.example.dao;

import org.example.model.Student;
import org.example.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends GenericDAO<Student> {

    @Override
    public void create(Student student) {
        String query = "INSERT INTO student (student_name, admission_year, department_id, department_name) " +
                "VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, student.getStudentName());
            statement.setInt(2, student.getAdmissionYear());
            statement.setInt(3, student.getDepartmentId());
            statement.setString(4, student.getDepartmentName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getById(int id) {
        String query = "SELECT * FROM student WHERE student_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("student_name");
                int admissionYear = resultSet.getInt("admission_year");
                int departmentId = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");
                return new Student(name, admissionYear, departmentId, departmentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Student student) throws SQLException {
        String sql = "UPDATE student SET student_name = ?, admission_year = ?, department_id = ?, department_name = ? WHERE student_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, student.getStudentName());
            statement.setInt(2, student.getAdmissionYear());
            statement.setInt(3, student.getDepartmentId());
            statement.setString(4, student.getDepartmentName());
            statement.setInt(5, student.getStudentId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM student WHERE student_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("student_name");
                int admissionYear = resultSet.getInt("admission_year");
                int departmentId = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");
                students.add(new Student(name, admissionYear, departmentId, departmentName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
