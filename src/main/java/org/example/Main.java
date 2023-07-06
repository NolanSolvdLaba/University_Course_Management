package org.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.dao.DepartmentMapper;
import org.example.model.Department;
import org.example.service.DepartmentService;
import org.example.util.MyBatisUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        // Create a SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            DepartmentService departmentService = new DepartmentService(departmentMapper);

            // Create a new department
            Department department = new Department("Computer Science");
            departmentService.create(department);
            System.out.println("Created department: " + department);

            // Get department by ID
            int departmentId = 1;
            Department fetchedDepartment = departmentService.getById(departmentId);
            System.out.println("Fetched department by ID " + departmentId + ": " + fetchedDepartment);

            // Update department
            fetchedDepartment.setDepartmentName("Software Engineering");
            departmentService.update(fetchedDepartment);
            System.out.println("Updated department: " + fetchedDepartment);

            // Delete department
            int departmentToDeleteId = 2;
            departmentService.delete(departmentToDeleteId);
            System.out.println("Deleted department with ID " + departmentToDeleteId);

            // Get all departments
            List<Department> departments = departmentService.getAll();
            System.out.println("All departments: ");
            for (Department d : departments) {
                System.out.println(d);
            }
        }
    }
}
