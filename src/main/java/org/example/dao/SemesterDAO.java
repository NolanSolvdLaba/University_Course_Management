package org.example.dao;

import org.example.model.Semester;
import org.example.util.ConnectionPool;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SemesterDAO extends GenericDAO<Semester> {

    @Override
    public void create(Semester semester) {
        String query = "INSERT INTO semester (semester_name, start_date, end_date) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, semester.getSemesterName());

            // Convert LocalDate to java.sql.Date
            Date startDate = Date.valueOf(semester.getStartDate());
            Date endDate = Date.valueOf(semester.getEndDate());

            statement.setDate(2, startDate);
            statement.setDate(3, endDate);

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int semesterId = generatedKeys.getInt(1);
                semester.setSemesterId(semesterId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Semester getById(int id) {
        String query = "SELECT * FROM semester WHERE semester_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String semesterName = resultSet.getString("semester_name");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
                Semester semester = new Semester(semesterName, startDate, endDate);
                semester.setSemesterId(id);
                return semester;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Semester semester) {
        String sql = "UPDATE semester SET semester_name = ?, start_date = ?, end_date = ? WHERE semester_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, semester.getSemesterName());
            statement.setDate(2, java.sql.Date.valueOf(semester.getStartDate()));
            statement.setDate(3, java.sql.Date.valueOf(semester.getEndDate()));
            statement.setInt(4, semester.getSemesterId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM semester WHERE semester_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Semester> getAll() {
        List<Semester> semesters = new ArrayList<>();
        String query = "SELECT * FROM semester";
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int semesterId = resultSet.getInt("semester_id");
                String semesterName = resultSet.getString("semester_name");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
                Semester semester = new Semester(semesterName, startDate, endDate);
                semester.setSemesterId(semesterId);
                semesters.add(semester);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return semesters;
    }
}
