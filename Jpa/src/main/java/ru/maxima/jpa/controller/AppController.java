package ru.maxima.jpa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maxima.jpa.dto.BookDto;
import ru.maxima.jpa.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class AppController {
    public AppController(BookService bookService) {
        this.bookService = bookService;
    }

    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<String> findBooks() {
        List<BookDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books.stream().map(BookDto::toString).toList().toString());
    }

    @GetMapping("/books/add")
    public String addBook(@RequestParam("name") String name,
                          @RequestParam("author") String author,
                          @RequestParam("yearPublication") String yearPublication) {
        bookService.addBook(new BookDto(name, author, yearPublication));
        return "redirect:/";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/books/get/{id}")
    public ResponseEntity<String> findBookById(@PathVariable("id") Long id) {
        Optional<BookDto> book = bookService.getUserById(id);
        return ResponseEntity.ok(book.toString());
    }
}

