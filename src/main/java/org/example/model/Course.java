package org.example.model;

public class Course {
    private int courseId;
    private String courseName;
    private int credits;
    private int semesterId;
    private int instructorId;
    private int departmentId;
    private int classroomId;
    private String description;

    public Course(int courseId, String courseName, int credits, int semesterId, int instructorId, int departmentId, int classroomId, String description) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.semesterId = semesterId;
        this.instructorId = instructorId;
        this.departmentId = departmentId;
        this.classroomId = classroomId;
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public String getDescription() {
        return description;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", semesterId=" + semesterId +
                ", instructorId=" + instructorId +
                ", departmentId=" + departmentId +
                ", classroomId=" + classroomId +
                ", description='" + description + '\'' +
                '}';
    }
}
