package org.example.factories;

import org.example.model.Administrator;
import org.example.model.Instructor;
import org.example.model.Student;

public interface AbstractFactory {
    Administrator createAdministrator();
    Instructor createInstructor();
    Student createStudent();
}
