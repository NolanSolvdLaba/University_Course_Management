package org.example;

import org.example.model.Department;
import org.example.service.DepartmentService;
import org.example.util.ConnectionPool;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Instantiate the DepartmentService
            DepartmentService departmentService = new DepartmentService();

            // Create a new department
            Department department1 = new Department("Computer Science");
            departmentService.create(department1);
            System.out.println("Created department: " + department1);

            // Get department by ID
            int departmentId = department1.getDepartmentId();
            Department retrievedDepartment1 = departmentService.getById(departmentId);
            System.out.println("Retrieved department: " + retrievedDepartment1);

            // Update department
            retrievedDepartment1.setDepartmentName("Information Technology");
            departmentService.update(retrievedDepartment1);
            System.out.println("Updated department: " + retrievedDepartment1);

            // Delete department
            departmentService.delete(departmentId);
            System.out.println("Department deleted.");

            // Get all departments
            List<Department> allDepartments = departmentService.getAll();
            System.out.println("All departments:");
            for (Department dept : allDepartments) {
                System.out.println(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
