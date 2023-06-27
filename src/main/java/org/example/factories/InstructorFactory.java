package org.example.factories;

import org.example.model.Administrator;
import org.example.model.Instructor;
import org.example.model.Student;

public class InstructorFactory implements AbstractFactory {

    @Override
    public Administrator createAdministrator() {
        return null;
    }

    @Override
    public Instructor createInstructor() {
        return new Instructor();
    }

    @Override
    public Student createStudent() {
        return null;
    }
}
