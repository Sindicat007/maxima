package ru.maxima.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.maxima.springmvc.entity.Book;
import ru.maxima.springmvc.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/")
public class MvcController {

    private final BookService bookService;

    public MvcController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("message", "Hello my friends");
        return "index";
    }

    @GetMapping("/showBooks")
    public String showBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/getFormForAddingBooks")
    public String showAddForm(){
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/showBooks";
    }
}
