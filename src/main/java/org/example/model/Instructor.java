package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Instructor")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Instructor")
public class Instructor {

    private int instructorId;

    @XmlElement(name = "instructorName")
    @JsonProperty("instructorName")
    private String instructorName;
    public Instructor(String instructorName) {
        this.instructorName = instructorName;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                '}';
    }
}
