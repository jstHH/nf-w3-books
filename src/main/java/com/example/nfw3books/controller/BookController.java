package com.example.nfw3books.controller;

import com.example.nfw3books.model.Book;
import com.example.nfw3books.model.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooksAsList();
    }

    @GetMapping(path = "{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @PostMapping(path = "{isbn}")
    public Book addBook(@PathVariable String isbn) {
        return bookService.addBook(isbn).get();
    }

    @DeleteMapping(path = "{isbn}")
    public boolean deleteBookByID(@PathVariable String isbn) {
        return bookService.deleteBookByIsbn(isbn);
    }

    @PutMapping
    public String changeTitel(@RequestParam String isbn, @RequestParam String titel) {
        return bookService.changeTitel(isbn, titel);
    }

    @DeleteMapping
    public String deleteAllBook() {
        if (bookService.deleteAllBooks()) {
            return "Löschen erfolgreich";
        }
        return "Löschen nicht erfolgreich";
    }




}
