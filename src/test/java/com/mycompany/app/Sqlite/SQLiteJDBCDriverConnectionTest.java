package com.mycompany.app.Sqlite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteJDBCDriverConnectionTest {

    @Test
    public void testSQLiteJDBCDriverConnection() throws SQLException {
        String sql_statement_for_tests = "SELECT 1 AS test";
        ResultSet result_set = SQLiteJDBCDriverConnection.executeQuery(sql_statement_for_tests);
        assertEquals(1, result_set.getInt("test"));
    }

}