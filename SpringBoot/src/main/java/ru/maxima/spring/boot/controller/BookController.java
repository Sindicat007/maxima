package ru.maxima.spring.boot.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.maxima.spring.boot.dto.BookDto;
import ru.maxima.spring.boot.entity.BookEntity;
import ru.maxima.spring.boot.service.BookService;

import java.util.List;
import java.util.Optional;

/*
 * Контроллер для работы с книгами.
 *
 * @author Sindicat
 */
@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        List<BookDto> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "listBooks";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("bookEntity", new BookEntity());
        return "addBook";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public String addBook(@ModelAttribute("BookDto") BookDto bookDto) {
        bookService.addBook(bookDto);
        return "redirect:/books";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/delete")
    public String showDeleteBookForm(Model model) {
        return "deleteBook";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Optional<BookDto> findById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }
}
