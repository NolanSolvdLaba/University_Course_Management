package org.example.dao;

import org.example.model.Department;

import java.util.List;

public interface DepartmentMapper {
    void create(Department department);
    Department getById(int id);
    void update(Department department);
    void delete(int id);
    List<Department> getAll();
}
