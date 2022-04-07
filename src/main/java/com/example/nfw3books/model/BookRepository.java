package com.example.nfw3books.model;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookRepository {
    Map<String, Book> books = new HashMap<>();


    public BookRepository(IsbnApiService apiService) {

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

    public Optional<Book> addBook (Book newBook){
        books.put(newBook.getId(), newBook);
        if (books.get(newBook.getId()).equals(newBook)) {
            return Optional.of(books.get(newBook.getId()));
        }
        return Optional.empty();
    }

    public boolean deleteBookByIsbn(String isbn){
        books.remove(isbn);
        if (books.containsKey(isbn)) {
            return false;
        }
        return true;
    }

    public String changeTitel (String isbn, String titel) {
        books.get(isbn).setTitle(titel);
        return books.get(isbn).getTitle();
    }

    public boolean deleteAllBooks() {
        books.clear();
        if (books.isEmpty()) {
            return true;
        }
        return false;
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
