package ru.maxima.springmvc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.maxima.springmvc.entity.Book;

import java.util.List;

@Repository
public class BookRepository {

    private final SessionFactory sessionFactory;

    public BookRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
@Transactional
    public List<Book> getAllBooks() {
        System.out.println("Получение всех книг");
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book", Book.class).getResultList();
    }
    @Transactional
    public void saveBook(Book book) {
        System.out.println("Сохранение книги");
        Session session = sessionFactory.getCurrentSession();
        session.persist(book);
    }
    @Transactional
    public Book getBook(int id) {
        System.out.println("Получение книги");
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, id);
    }
}
