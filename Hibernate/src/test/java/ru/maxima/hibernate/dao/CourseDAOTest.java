package ru.maxima.hibernate.dao;

import org.junit.jupiter.api.*;
import ru.maxima.hibernate.entity.Course;

import java.util.HashSet;
import java.util.List;

class CourseDAOTest {
    CourseDAO courseDAO = new CourseDAO();

    @Test
    @DisplayName("Save course")
    void saveCourse() {
        Course course = new Course();
        course.setId(5L);
        course.setName("JavaRush");
        courseDAO.saveCourse(course);
        Assertions.assertNotNull(courseDAO.getCourseById(course.getId()));
    }

    @Test
    @DisplayName("Get course by id")
    void getCourseById() {
        Course course = courseDAO.getCourseById(1L);
        Assertions.assertNotNull(course);
        System.out.println(course.getName());

    }

    @Test
    @DisplayName("Get all courses")
    void getAllCourses() {
        List<Course> courses = courseDAO.getAllCourses();
        Assertions.assertNotNull(courses);
    }

    @Test
    @DisplayName("Update course")
    void updateCourse() {
        Course course = new Course();
        course.setName("Java3113");
        course.setId(5L);
        course.setStudents(new HashSet<>());

        courseDAO.updateCourse(course);
        Assertions.assertEquals(course, courseDAO.getCourseById(course.getId()));
    }

    @Test
    @DisplayName("Delete course")
    void deleteCourse() {
        Course course = new Course();
        course.setId(5L);
        courseDAO.deleteCourse(course);
        Assertions.assertNull(courseDAO.getCourseById(course.getId()));
    }

}