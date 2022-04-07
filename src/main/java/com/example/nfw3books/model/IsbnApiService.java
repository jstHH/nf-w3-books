package com.example.nfw3books.model;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IsbnApiService {
    private final WebClient webClient;

    public IsbnApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Book getBookbyIsbn(String isbn) {
        String url = "https://my-json-server.typicode.com/Flooooooooooorian/BookApi/books/" + isbn;
        Book book = webClient.get()
                .uri(url)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .toEntity(Book.class)
                .block()
                .getBody();

        return book;
    }
}
