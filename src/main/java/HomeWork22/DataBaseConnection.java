package HomeWork22;

import java.sql.*;

public class DataBaseConnection {
    private static final String DB_URL = "jdbc:mysql://db4free.net:3306/hillelgav";
    private static final String DB_USER = "gavrish";
    private static final String DB_PASSWORD = "12345678";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void close (Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
