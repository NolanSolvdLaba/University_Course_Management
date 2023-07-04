package org.example.dao;

import org.example.model.Instructor;
import org.example.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstructorDAO {

    public void create(Instructor instructor) {
        String query = "INSERT INTO instructor (instructor_name) VALUES (?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, instructor.getInstructorName());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int instructorId = generatedKeys.getInt(1);
                instructor.setInstructorId(instructorId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Instructor getById(int id) {
        String query = "SELECT * FROM instructor WHERE instructor_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String instructorName = resultSet.getString("instructor_name");
                Instructor instructor = new Instructor(instructorName);
                instructor.setInstructorId(id);
                return instructor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Instructor instructor) {
        String sql = "UPDATE instructor SET instructor_name = ? WHERE instructor_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, instructor.getInstructorName());
            statement.setInt(2, instructor.getInstructorId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM instructor WHERE instructor_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Instructor> getAll() {
        List<Instructor> instructors = new ArrayList<>();
        String query = "SELECT * FROM instructor";
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int instructorId = resultSet.getInt("instructor_id");
                String instructorName = resultSet.getString("instructor_name");
                Instructor instructor = new Instructor(instructorName);
                instructor.setInstructorId(instructorId);
                instructors.add(instructor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instructors;
    }
}
