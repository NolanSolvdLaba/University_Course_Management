package org.example.service;

import org.example.dao.DepartmentDAO;
import org.example.model.Department;

import java.util.List;

public class DepartmentService implements GenericService<Department> {

    private final DepartmentDAO departmentDAO;

    public DepartmentService() {
        this.departmentDAO = new DepartmentDAO();
    }

    @Override
    public void create(Department department) {
        departmentDAO.create(department);
    }

    @Override
    public Department getById(int id) {
        return departmentDAO.getById(id);
    }

    @Override
    public void update(Department department) {
        departmentDAO.update(department);
    }

    @Override
    public void delete(int id) {
        departmentDAO.delete(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentDAO.getAll();
    }
}
