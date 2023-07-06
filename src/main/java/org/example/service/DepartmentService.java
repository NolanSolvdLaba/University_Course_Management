package org.example.service;

import org.example.dao.DepartmentMapper;
import org.example.model.Department;

import java.util.List;

public class DepartmentService implements GenericService<Department> {

    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public void create(Department department) {
        departmentMapper.create(department);
    }

    @Override
    public Department getById(int id) {
        return departmentMapper.getById(id);
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public void delete(int id) {
        departmentMapper.delete(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentMapper.getAll();
    }
}
