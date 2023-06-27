package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Student")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Student")
public class Student extends User {

    @JsonIgnore
    @XmlTransient
    private int studentId;

    @XmlElement(name = "studentName")
    @JsonProperty("studentName")
    private String studentName;

    @XmlElement(name = "admissionYear")
    @JsonProperty("admissionYear")
    private int admissionYear;

    @XmlElement(name = "departmentId")
    @JsonProperty("departmentId")
    private int departmentId;

    @XmlElement(name = "departmentName")
    @JsonProperty("departmentName")
    private String departmentName;

    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    @JsonProperty("courses")
    private List<Course> courses;

    public Student() {
        // Default constructor
    }

    public Student(String studentName, int admissionYear, int departmentId, String departmentName) {
        this.studentName = studentName;
        this.admissionYear = admissionYear;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
