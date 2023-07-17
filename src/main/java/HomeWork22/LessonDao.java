package HomeWork22;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private DataBaseConnection dbConnection;

    public LessonDao(DataBaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addLesson(Lesson lesson) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnection.getConnection();
            String query = "INSERT INTO Lesson (name, homework_id) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, lesson.getName());
            statement.setInt(2, addHomework(lesson.getHomework(), connection));
            statement.executeUpdate();
        }finally {
            if (statement != null) {
                statement.close();
            }
            dbConnection.close(connection);
        }
    }

    private int addHomework(Homework homework, Connection connection) throws SQLException {
        String query = "INSERT INTO Homework (name, description) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, homework.getName());
        statement.setString(2, homework.getDescription());
        statement.executeUpdate();

        ResultSet generatedKeys = statement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getInt(1);
        }else {
            throw new SQLException("Failed to insert homework, no ID obtained.");
        }
    }

    public void deleteLesson(int lessonId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dbConnection.getConnection();
            String query = "DELETE FROM Lesson WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, lessonId);
            statement.executeUpdate();
        }finally {
            if (statement != null) {
                statement.close();
            }
            dbConnection.close(connection);
        }
    }

    public List<Lesson> getAllLessons() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnection.getConnection();
            String query = "SELECT l.id, l.name, h.name, h.description " +
                    "FROM Lesson AS l " +
                    "JOIN Homework AS h ON l.homework_id = h.id";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            List<Lesson> lessons = new ArrayList<>();

            while (resultSet.next()) {
                //int lessonId = resultSet.getInt(1);
                String lessonName = resultSet.getString(2);
                String homeworkName = resultSet.getString(3);
                String homeworkDescription = resultSet.getString(4);

                Homework homework = new Homework(homeworkName, homeworkDescription);
                Lesson lesson = new Lesson(lessonName,homework);
                lessons.add(lesson);
            }

            return lessons;

        }finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            dbConnection.close(connection);
        }
    }

    public Lesson getLessonById(int lessonId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnection.getConnection();
            String query = "SELECT l.name, h.name, h.description " +
                    "FROM Lesson AS l " +
                    "JOIN Homework AS h ON l.homework_id = h.id " +
                    "WHERE l.id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, lessonId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String lessonName = resultSet.getString(1);
                String homeworkName = resultSet.getString(2);
                String homeworkDescription = resultSet.getString(3);

                Homework homework = new Homework(homeworkName, homeworkDescription);
                return new Lesson(lessonName, homework);
            }else {
                return null;
            }
        }finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            dbConnection.close(connection);
        }
    }
}
