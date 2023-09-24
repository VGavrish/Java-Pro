CREATE TABLE Users
(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
password VARCHAR(255), role VARCHAR(255)
);


INSERT INTO Users (name, password, role)
VALUES ('Vitalii', '$2a$10$wvHYKJbP4eLj2z4RtJd/KO5tDc2aOnaEHK8jVnhMBa.mF8sjkOH3n', 'ADMIN');
