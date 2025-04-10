package ru.maxima.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.maxima.hibernate.config.HibernateUtil;
import ru.maxima.hibernate.entity.Course;

import java.util.List;

public class CourseDAO {

    public void saveCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
        }
    }

    public void updateCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(course);
            transaction.commit();
        }
    }

    public Course getCourseById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Course.class, id);
        }
    }

    public void deleteCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(course);
            transaction.commit();
        }
    }

    public List<Course> getAllCourses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Course> courses = session.createQuery("from Course").list();
            return courses;
        }
    }
}
