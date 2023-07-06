package org.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.dao.SemesterMapper;
import org.example.model.Semester;
import org.example.service.SemesterService;
import org.example.util.MyBatisUtil;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        // Create a SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            SemesterMapper semesterMapper = sqlSession.getMapper(SemesterMapper.class);
            SemesterService semesterService = new SemesterService(semesterMapper);

            // Create a new semester
            Semester semester = new Semester("Spring", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 5, 31));
            semesterService.create(semester);
            System.out.println("Created semester: " + semester);

            // Get semester by ID
            int semesterId = 1;
            Semester fetchedSemester = semesterService.getById(semesterId);
            System.out.println("Fetched semester by ID " + semesterId + ": " + fetchedSemester);

            // Delete semester
            int semesterToDeleteId = 2;
            semesterService.delete(semesterToDeleteId);
            System.out.println("Deleted semester with ID " + semesterToDeleteId);

            // Get all semesters
            List<Semester> semesters = semesterService.getAll();
            System.out.println("All semesters: ");
            for (Semester s : semesters) {
                System.out.println(s);
            }
        }
    }
}
