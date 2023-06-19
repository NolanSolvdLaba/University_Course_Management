package org.example.dao;

import org.example.model.Department;
import org.example.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO extends GenericDAO<Department> {

    @Override
    public void create(Department department) {
        String query = "INSERT INTO department (department_name) VALUES (?)";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, department.getDepartmentName());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int departmentId = generatedKeys.getInt(1);
                department.setDepartmentId(departmentId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Department getById(int id) {
        String query = "SELECT * FROM department WHERE department_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String departmentName = resultSet.getString("department_name");
                Department department = new Department(departmentName);
                department.setDepartmentId(id);
                return department;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Department department) {
        String sql = "UPDATE department SET department_name = ? WHERE department_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, department.getDepartmentName());
            statement.setInt(2, department.getDepartmentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM department WHERE department_id = ?";
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT * FROM department";
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int departmentId = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");
                Department department = new Department(departmentName);
                department.setDepartmentId(departmentId);
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }
}
