package ru.maxima.hibernate.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.maxima.hibernate.entity.Student;

import java.util.HashSet;
import java.util.List;


class StudentDAOTest {
    StudentDAO studentDAO = new StudentDAO();

    @Test
    @DisplayName("Save student")
    void saveStudent() {
        Student student = new Student();
        student.setId(5L);
        student.setName("Veniamin");
        studentDAO.saveStudent(student);
        Assertions.assertNotNull(studentDAO.getStudentById(student.getId()));
    }

    @Test
    @DisplayName("Get student by id")
    void getStudentById() {
        Student student = studentDAO.getStudentById(1L);
        Assertions.assertNotNull(student);
        System.out.println(student.getName());

    }

    @Test
    @DisplayName("Get all students")
    void getAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        Assertions.assertNotNull(students);
    }

    @Test
    @DisplayName("Update student")
    void updateStudent() {
        Student student = new Student();
        student.setName("Leonidas");
        student.setId(4L);
        student.setCourses(new HashSet<>());

        studentDAO.updateStudent(student);
        Assertions.assertEquals(student, studentDAO.getStudentById(student.getId()));

    }

    @Test
    @DisplayName("Delete student")
    void deleteStudent() {
        Student student = new Student();
        student.setId(5L);
        studentDAO.deleteStudent(student);
        Assertions.assertNull(studentDAO.getStudentById(student.getId()));
    }
}