package org.example.model;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

import org.example.util.DateAdapter;

@XmlRootElement(name = "semester")
@XmlAccessorType(XmlAccessType.FIELD)
public class Semester {
    @XmlAttribute(name = "semester_id")
    private int semesterId;

    @XmlElement(name = "semester_name")
    private String semesterName;

    @XmlElement(name = "start_date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDate startDate;

    @XmlElement(name = "end_date")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private LocalDate endDate;


    public Semester(String semesterName, LocalDate startDate, LocalDate endDate) {
        this.semesterName = semesterName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semesterId=" + semesterId +
                ", semesterName='" + semesterName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
