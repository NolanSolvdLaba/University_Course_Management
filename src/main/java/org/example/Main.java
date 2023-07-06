package org.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.dao.ClassroomMapper;
import org.example.model.Classroom;
import org.example.service.ClassroomService;
import org.example.util.MyBatisUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        // Create a SqlSession
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ClassroomMapper classroomMapper = sqlSession.getMapper(ClassroomMapper.class);
            ClassroomService classroomService = new ClassroomService(classroomMapper);

            // Create a new classroom
            Classroom classroom = new Classroom(171, 30);
            classroomService.create(classroom);
            System.out.println("Created classroom: " + classroom);

            // Get classroom by ID
            int classroomId = 1;
            Classroom fetchedClassroom = classroomService.getById(classroomId);
            System.out.println("Fetched classroom by ID " + classroomId + ": " + fetchedClassroom);

            // Update classroom
            classroom.setCapacity(40);
            classroomService.update(classroom);
            System.out.println("Updated classroom: " + classroom);

            // Delete classroom
            int classroomToDeleteId = 2;
            classroomService.delete(classroomToDeleteId);
            System.out.println("Deleted classroom with ID " + classroomToDeleteId);

            // Get all classrooms
            List<Classroom> classrooms = classroomService.getAll();
            System.out.println("All classrooms: ");
            for (Classroom c : classrooms) {
                System.out.println(c);
            }
        }
    }
}
