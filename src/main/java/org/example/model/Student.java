package org.example.model;

public class Student {
    private int studentId;
    private String studentName;
    private int admissionYear;
    private int departmentId;
    private String departmentName;

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
}
