package org.example.model;

public class Classroom {
    private int classroomId;
    private int classroomNumber;

    private int capacity;

    public Classroom(int classroomNumber, int capacity) {
        this.classroomNumber = classroomNumber;
        this.capacity = capacity;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
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
                "classroomId=" + classroomId +
                ", classroomNumber=" + classroomNumber +
                ", capacity=" + capacity +
                '}';
    }
}
