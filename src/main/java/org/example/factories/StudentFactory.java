package org.example.factories;

import org.example.model.Administrator;
import org.example.model.Instructor;
import org.example.model.Student;
import org.example.model.User;

public class StudentFactory implements AbstractFactory {

    @Override
    public Administrator createAdministrator() {
        return null;
    }

    @Override
    public Instructor createInstructor() {
        return null;
    }

    @Override
    public Student createStudent() {
        return new Student();
    }
}
