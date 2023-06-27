package org.example.factories;

import org.example.model.Administrator;
import org.example.model.Instructor;
import org.example.model.Student;

public class AdministratorFactory implements AbstractFactory {

    @Override
    public Administrator createAdministrator() {
        return new Administrator();
    }

    @Override
    public Instructor createInstructor() {
        return null;
    }

    @Override
    public Student createStudent() {
        return null;
    }
}
