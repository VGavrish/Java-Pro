package org.example.HomeWork30;

import java.util.List;

public class Main {
    public static void main(String[] args) {
    StudentDAO studentDAO = new StudentDAO();

    Student student1 = new Student();
    student1.setName("John");
    student1.setEmail("john@gmail.com");
    studentDAO.addStudent(student1);

    Student student2 = new Student();
    student2.setName("Sam");
    student2.setEmail("sam@gmail.com");
    studentDAO.addStudent(student2);

    List<Student> studentList = studentDAO.getAllStudents();
    for (Student student : studentList) {
        System.out.println("Student ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Email: " + student.getEmail());
    }
    studentDAO.findById(1);
    studentDAO.removeStudent(student2);
    }
}