package ru.maxima.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maxima.jpa.dto.BookDto;
import ru.maxima.jpa.service.BookService;

import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class AppController {
    private final BookService bookService;

    @GetMapping("/getAllBooks")
    public ResponseEntity<String> findBooks() {
        return ResponseEntity.ok(bookService.getAllBooks().toString());
    }

    @GetMapping("/add")
    public String addBook(@RequestParam("name") String name,
                          @RequestParam("author") String author,
                          @RequestParam("yearPublication") String yearPublication) {
        bookService.addBook(new BookDto(name, author, yearPublication));
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> findBookById(@PathVariable("id") Long id) {
        Optional<BookDto> book = bookService.getUserById(id);
        if (book.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book.toString());
    }
}

