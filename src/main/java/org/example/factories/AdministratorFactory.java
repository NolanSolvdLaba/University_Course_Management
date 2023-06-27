package org.example.factories;

import org.example.model.Administrator;

public class AdministratorFactory implements AbstractFactory {

    @Override
    public Administrator createUser() {
        return new Administrator();

    }
}

