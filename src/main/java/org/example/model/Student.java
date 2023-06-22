package org.example.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlElement(name = "studentId")
    private int studentId;

    @XmlElement(name = "studentName")
    private String studentName;

    @XmlElement(name = "admissionYear")
    private int admissionYear;

    @XmlElement(name = "departmentId")
    private int departmentId;

    @XmlElement(name = "departmentName")
    private String departmentName;

    @XmlElementWrapper(name = "courses")
    @XmlElement(name = "course")
    private List<Course> courses;

    public Student() {
    }

    public Student(String studentName, int admissionYear, int departmentId, String departmentName, List<Course> courses) {
        this.studentName = studentName;
        this.admissionYear = admissionYear;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.courses = courses;
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
