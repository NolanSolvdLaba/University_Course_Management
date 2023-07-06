package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "classroom")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Classroom")
public class Classroom {

    @XmlElement(name = "classroom_number")
    @JsonProperty("classroomNumber")
    private int classroomNumber;

    @XmlElement(name = "capacity")
    @JsonProperty("capacity")
    private int capacity;

    public Classroom(int classroomNumber, int capacity) {
        this.classroomNumber = classroomNumber;
        this.capacity = capacity;
    }

    public int getClassroomNumber() {
        return this.classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomNumber=" + classroomNumber +
                ", capacity=" + capacity +
                '}';
    }
}
