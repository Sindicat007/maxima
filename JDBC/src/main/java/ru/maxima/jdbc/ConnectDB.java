package ru.maxima.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/Jdbc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    private ConnectDB() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
