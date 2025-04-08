package ru.maxima.spring.boot.controller;

import lombok.RequiredArgsConstructor;
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
 */

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
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
    @GetMapping("/delete-book")
    public String showDeleteBookForm() {
        return "deleteBook";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Optional<BookDto> findById(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }
}
