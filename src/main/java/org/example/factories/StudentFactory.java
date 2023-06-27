package org.example.factories;

import org.example.model.Student;
import org.example.model.User;

public class StudentFactory implements AbstractFactory {

    @Override
    public User createUser() {
        return new Student();
    }
}
