package org.example.dao;

import org.example.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseDAO {

    @Insert("INSERT INTO course (course_name, credits, semester_id, instructor_id, department_id, classroom_id, description) " +
            "VALUES (#{courseName}, #{credits}, #{semesterId}, #{instructorId}, #{departmentId}, #{classroomId}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "courseId")
    void create(Course course);

    @Select("SELECT * FROM course WHERE course_id = #{id}")
    Course getById(int id);

    @Update("UPDATE course SET course_name = #{courseName}, credits = #{credits}, semester_id = #{semesterId}, " +
            "instructor_id = #{instructorId}, department_id = #{departmentId}, classroom_id = #{classroomId}, " +
            "description = #{description} WHERE course_id = #{courseId}")
    void update(Course course);

    @Delete("DELETE FROM course WHERE course_id = #{id}")
    void delete(int id);

    @Select("SELECT * FROM course")
    List<Course> getAll();
}
