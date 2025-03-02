package ru.maxima.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import ru.maxima.hibernate.config.HibernateUtil;
import ru.maxima.hibernate.entity.Course;

import java.util.List;

class CourseDAOTest {

    private static SessionFactory sessionFactory;
    private static Session session;


    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null
                && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

    @Test
    @DisplayName("Save course")
    void saveCourse() {
        session.beginTransaction();

        Course course = new Course();
        course.setName("Java2222");

        var id = (Long) session.save(course);
        session.getTransaction().commit();
        Assertions.assertTrue(id > 0);
    }

//    @Test
//    @DisplayName("Update course")
//    void updateCourse() {
//        Course course = new Course();
//        course.setName("Java3333");
//        session.update(course);
//        Assertions.assertEquals(course, session.get(Course.class, course.getId()));
//    }
//
//    @Test
//    @DisplayName("Get course by id")
//    void getCourseById() {
//        Course course = new Course();
//        course.setId(1L);
//        Assertions.assertEquals("Java", session.get(Course.class, course.getId()));
//    }
//
//    @Test
//    @DisplayName("Delete course")
//    void deleteCourse() {
//        Course course = new Course();
//        course.setId(1L);
//        Assertions.assertNull(course);
//    }
//
//    @Test
//    @DisplayName("Get all courses")
//    void getAllCourses() {
//        Course course = new Course();
//        course.setName("Java2222");
//        List<Course> courses = session.createQuery("FROM Course").list();
//        Assertions.assertNotNull(courses);
//    }
}