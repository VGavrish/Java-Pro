package HomeWork22;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();

        LessonDao lessonDao = new LessonDao(dataBaseConnection);

        try {
            Homework homework = new Homework("Math homework", "Complite exercises 1-5");
            Lesson lesson = new Lesson("Math lesson", homework);

            lessonDao.addLesson(lesson);

            System.out.println(lesson.getHomework());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
