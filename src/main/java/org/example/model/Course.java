package org.example.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "course")
@XmlAccessorType(XmlAccessType.FIELD)
public class Course {

    @XmlAttribute(name = "course_id")
    private int courseId;

    @XmlElement(name = "course_name")
    private String courseName;

    @XmlElement(name = "credits")
    private int credits;

    @XmlElement(name = "semester_id")
    private int semesterId;

    @XmlElement(name = "instructor_id")
    private int instructorId;

    @XmlElement(name = "department_id")
    private int departmentId;

    @XmlElement(name = "classroom_id")
    private int classroomId;

    @XmlElement(name = "description")
    private String description;

    public Course() {
    }

    public Course(String courseName, int credits, int semesterId, int instructorId, int departmentId, int classroomId, String description) {
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

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getDescription() {
        return description;
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
