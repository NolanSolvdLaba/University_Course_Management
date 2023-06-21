package org.example.dao;

import org.example.model.Classroom;
import org.example.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDAO {

    public void create(Classroom classroom) {
        String query = "INSERT INTO classroom (classroom_number, capacity) VALUES (?, ?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, classroom.getClassroomNumber());
            statement.setInt(2, classroom.getCapacity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Classroom getById(int id) {
        String query = "SELECT * FROM classroom WHERE classroom_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String classroomNumber = resultSet.getString("classroom_number");
                int capacity = resultSet.getInt("capacity");
                Classroom classroom = new Classroom(id, classroomNumber, capacity);
                return classroom;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Classroom classroom) {
        String sql = "UPDATE classroom SET classroom_number = ?, capacity = ? WHERE classroom_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, classroom.getClassroomNumber());
            statement.setInt(2, classroom.getCapacity());
            statement.setInt(3, classroom.getClassroomID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM classroom WHERE classroom_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Classroom> getAll() {
        List<Classroom> classrooms = new ArrayList<>();
        String query = "SELECT * FROM classroom";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int classroomId = resultSet.getInt("classroom_id");
                String classroomNumber = resultSet.getString("classroom_number");
                int capacity = resultSet.getInt("capacity");
                Classroom classroom = new Classroom(classroomId, classroomNumber, capacity);
                classrooms.add(classroom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classrooms;
    }
}
