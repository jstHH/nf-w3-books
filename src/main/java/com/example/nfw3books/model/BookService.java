package com.example.nfw3books.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repository;
    private final IsbnApiService apiService;

    @Autowired
    public BookService(BookRepository repository, IsbnApiService apiService) {
        this.repository = repository;
        this.apiService = apiService;
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

    public Optional<Book> addBook(String isbn) {
        Book newBook = apiService.getBookbyIsbn(isbn);
        repository.addBook(newBook);
        return Optional.of(newBook);
    }

    public boolean deleteBookByIsbn(String isbn) {
        return repository.deleteBookByIsbn(isbn);
    }

    public String changeTitel(String isbn, String titel) {
        return repository.changeTitel(isbn, titel);
    }

    public boolean deleteAllBooks() {
        return repository.deleteAllBooks();
    }
}
