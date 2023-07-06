package org.example.model;

import java.util.List;

public class Student extends User {

    private int studentId;

    private String studentName;

    private int admissionYear;

    private int departmentId;

    private String departmentName;

    private List<Course> courses;

    public Student(String studentName, int admissionYear, int departmentId, String departmentName) {
        this.studentName = studentName;
        this.admissionYear = admissionYear;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Student() {
        super();
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

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", admissionYear=" + admissionYear +
                ", departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
