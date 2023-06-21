package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Classroom {

    @JsonProperty("classroom_id")
    private int classroomID;

    @JsonProperty("classroom_number")
    private String classroomNumber;

    @JsonProperty("capacity")
    private int capacity;

    public Classroom(int classroomID, String classroomNumber, int capacity) {
        this.classroomID = classroomID;
        this.classroomNumber = classroomNumber;
        this.capacity = capacity;
    }

    public int getClassroomID() {
        return classroomID;
    }

    public void setClassroomID(int classroomID) {
        this.classroomID = classroomID;
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
