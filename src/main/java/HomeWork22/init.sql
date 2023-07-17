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