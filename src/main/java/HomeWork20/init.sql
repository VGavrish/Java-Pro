CREATE TABLE Homework (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE Lesson (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    updatedAT TIMESTAMP,
    homework_id INT,
    FOREIGN (homework_id) REFERENCES Homework(id)
);

CREATE TABLE Schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    updatedAt TIMESTAMP
);

CREATE TABLE Lesson_Schedule (
    lesson_id INT,
    schedule_id INT,
    FOREIGN KEY (lesson_id) REFERENCES Lesson(id),
    FOREIGN KEY (schedule_id) REFERENCES Schedule(id),
    PRIMARY KEY (lesson_id, schedule_id)
);