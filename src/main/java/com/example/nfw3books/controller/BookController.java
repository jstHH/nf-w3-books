package com.example.nfw3books.controller;

import com.example.nfw3books.model.Book;
import com.example.nfw3books.model.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    BookService bookService;

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

    @PostMapping
    public boolean addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping(path = "{isbn}")
    public boolean deleteBookByID(@PathVariable String isbn) {
        return bookService.deleteBookByIsbn(isbn);
    }

    @PutMapping
    public String changeTitel(@RequestParam String isbn, @RequestParam String titel) {
        return bookService.changeTitel(isbn, titel);
    }




}
