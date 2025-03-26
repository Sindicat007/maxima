package ru.maxima.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.maxima.jpa.dto.BookDto;
import ru.maxima.jpa.service.BookService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/books")
public class ViewController {

    private final BookService bookService;

    @PostMapping("/")
    public String addBook(@RequestParam("name") String name,
                          @RequestParam("author") String author,
                          @RequestParam("yearPublication") String yearPublication) {
        bookService.addBook(new BookDto(name, author, yearPublication));
        return "redirect:/books/";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/books/";
    }
}
