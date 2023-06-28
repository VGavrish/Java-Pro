SELECT *
FROM Homework;

SELECT Lesson.*, Homework.name AS homework_name, Homework.description AS homework_description
FROM Lesson
JOIN Homework
ON Lesson.Homework_id = Homework.id;

SELECT Lesson.*, Homework.name AS homework_name, Homework.description AS homework_description
FROM Lesson
JOIN Homework
ON Lesson.Homework_id = Homework.id
ORDER BY Lesson.updatedAT;

SELECT Schedule.*, Lesson.name AS less_name, Lesson.updatedAT AS less_updatedAT
FROM Schedule
JOIN Lesson_Schedule
ON Schedule.id = Lesson_Schedule.schedule_id
JOIN Leson
ON Lesson_Schedule.lesson_id = Lesson.id;

SELECT Schedule.name, COUNT(Lesson_Schedule.lesson_id) AS lesson_count
FROM Schedule
LEFT JOIN Lesson_Schedule
ON Schedule.id = Lesson_Schedule.schedule_id
GROUP BY Schedule.id;