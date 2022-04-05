package com.example.nfw3books.model;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookRepository {
    Map<String, Book> books = new HashMap<>();

    public BookRepository() {
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    public List<Book> getBooksAsList() {
        List<Book> books = new ArrayList<Book>(this.books.values());
        return books;
    }

    public Optional<Book> getBookByIsbn(String isbn) {
        if (books.containsKey(isbn)) {
            return Optional.of(books.get(isbn));
        }
        return Optional.empty();
    }

    public boolean addBook (Book newBook){
        books.put(newBook.getIsbn(), newBook);
        if (books.get(newBook.getIsbn()).equals(newBook)) {
            return true;
        }
        return false;
    }

    public boolean deleteBookByIsbn(String isbn){
        books.remove(isbn);
        if (books.containsKey(isbn)) {
            return false;
        }
        return true;
    }

    public String changeTitel (String isbn, String titel) {
        books.get(isbn).setTitel(titel);
        return books.get(isbn).getTitel();
    }



    @Override
    public String toString() {
        return "BookRepository{" +
                "books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookRepository that = (BookRepository) o;
        return Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
