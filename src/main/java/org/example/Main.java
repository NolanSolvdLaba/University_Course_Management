package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.ClassroomMapper;
import org.example.model.Classroom;
import org.example.util.MyBatisUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            ClassroomMapper classroomMapper = sqlSession.getMapper(ClassroomMapper.class);

            // Create a new classroom
            Classroom classroom = new Classroom("101", 30);
            classroomMapper.create(classroom);
            System.out.println("Created classroom: " + classroom);

            // Get classroom by ID
            int classroomId = 1;
            Classroom fetchedClassroom = classroomMapper.getById(classroomId);
            System.out.println("Fetched classroom by ID " + classroomId + ": " + fetchedClassroom);

            // Update classroom
            fetchedClassroom.setCapacity(35);
            classroomMapper.update(fetchedClassroom);
            System.out.println("Updated classroom: " + fetchedClassroom);

            // Delete classroom
            int classroomToDeleteId = 2;
            classroomMapper.delete(classroomToDeleteId);
            System.out.println("Deleted classroom with ID " + classroomToDeleteId);

            // Get all classrooms
            List<Classroom> classrooms = classroomMapper.getAll();
            System.out.println("All classrooms: ");
            for (Classroom c : classrooms) {
                System.out.println(c);
            }

            sqlSession.commit(); // Commit the changes
        }
    }
}
