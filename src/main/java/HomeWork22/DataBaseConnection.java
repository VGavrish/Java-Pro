package HomeWork22;

import java.sql.*;

public class DataBaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close (Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
