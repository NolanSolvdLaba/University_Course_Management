package org.example.service;

import org.example.dao.DepartmentMapper;
import org.example.model.Department;

import java.util.List;

public class DepartmentService {

    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public void create(Department department) {
        departmentMapper.create(department);
    }

    public Department getById(int id) {
        return departmentMapper.getById(id);
    }

    public void update(Department department) {
        departmentMapper.update(department);
    }

    public void delete(int id) {
        departmentMapper.delete(id);
    }

    public List<Department> getAll() {
        return departmentMapper.getAll();
    }
}
