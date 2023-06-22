package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "grade")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Grades")
public class Grades {

    @JsonIgnore
    @XmlTransient
    private int gradeId;

    @XmlElement(name="enrollmentId")
    @JsonProperty("instructorId")
    private int enrollmentId;

    @XmlElement(name="grade")
    @JsonProperty("grade")
    private String grade;

    @XmlElement(name="courseId")
    @JsonProperty("courseId")
    private int courseId;

    @XmlElement(name="studentId")
    @JsonProperty("studentId")
    private int studentId;


    public Grades(int gradeId, int enrollmentId, String grade, int courseId, int studentId) {
        this.gradeId = gradeId;
        this.enrollmentId = enrollmentId;
        this.grade = grade;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
