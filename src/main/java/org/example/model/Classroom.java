package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "classroom")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Classroom")
public class Classroom {

    @JsonProperty("classroomId")
    private int classroomId;

    @XmlElement(name = "classroom_number")
    @JsonProperty("classroomNumber")
    private String classroomNumber;

    @XmlElement(name = "capacity")
    @JsonProperty("capacity")
    private int capacity;

    public Classroom(int classroomId, String classroomNumber, int capacity) {
        this.classroomId = classroomId;
        this.classroomNumber = classroomNumber;
        this.capacity = capacity;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(String classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
