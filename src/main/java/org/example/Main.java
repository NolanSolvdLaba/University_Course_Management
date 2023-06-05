package org.example;

import org.example.util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Get a connection from the connection pool
            Connection connection = ConnectionPool.getConnection();

            // Perform your database operations using the connection
            // ...

            // Close the connection when you're done
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}