package org.example.dao;

import org.example.util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class GenericDAO<T> {
    protected Connection connection;

    public GenericDAO() {
        try {
            connection = ConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            // connection exception
        }
    }

    public void create(T entity) {
        // create
    }

    public T getById(int id) {
        // operation by ID
        return null;
    }

    public void update(T entity) {
        // update
    }

    public void delete(int id) {
        // delete
    }
}
