package com.example.nfw3books.controller;

import com.example.nfw3books.model.Book;
import com.example.nfw3books.model.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebTestClient testClient;

    @BeforeEach
    public void clear() {
        testClient.delete()
                .uri("http://localhost:" + port + "/book")
                .exchange()
                .expectStatus().is2xxSuccessful();
    }




    @Test
    void getBooks() {
    }

    @Test
    void getBookByIsbn() {
    }

    @Test
    void addBook() {
        //Given
        Book testBook = new Book("978-3-8362-8745-6", "Java ist auch eine Insel", "Christian Ullenboom");

        //When
        Book actual = testClient.post()
                .uri("http://localhost:" + port + "/book/978-3-8362-8745-6")
                .bodyValue(testBook)
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();

        //Then
        Book expected = testBook;

        assertEquals(expected, actual);



    }

    @Test
    void deleteBookByID() {
    }

    @Test
    void changeTitel() {
    }
}