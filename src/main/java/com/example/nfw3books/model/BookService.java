package com.example.nfw3books.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Map<String, Book> getBooks() {
        return repository.getBooks();
    }

    public List<Book> getBooksAsList() {
       return repository.getBooksAsList();
    }

    public Book getBookByIsbn(String isbn) {
        return repository.getBookByIsbn(isbn).get();
    }

    public boolean addBook(Book book) {
        return repository.addBook(book);
    }

    public boolean deleteBookByIsbn(String isbn) {
        return repository.deleteBookByIsbn(isbn);
    }

    public String changeTitel(String isbn, String titel) {
        return repository.changeTitel(isbn, titel);
    }
}
