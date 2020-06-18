package com.mycompany.app.Sqlite;

import java.sql.*;

public class SQLiteJDBCDriverConnection {

    private static final String DATABASE_CONNECTION_STRING = "jdbc:sqlite::resource:db/my_database.db";

    public static ResultSet executeQuery(String query) {
        ResultSet result_set = null;

        Connection db_connection = getConnection();
        Statement statement = createStatement(db_connection);

        try {
            result_set = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Could not execute SQL statement: " + e.getMessage());
        }

        return result_set;
    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection(DATABASE_CONNECTION_STRING);
        } catch (SQLException e) {
            System.out.println("Could not connect to the database: " + e.getMessage());
        }
        return connection;
    }

    private static Statement createStatement(Connection db_connection) {
        Statement statement = null;
        try {
            statement = db_connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Could not create database statement: " + e.getMessage());
        }
        return statement;
    }

}
