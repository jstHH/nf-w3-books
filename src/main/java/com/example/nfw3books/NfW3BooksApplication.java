package com.example.nfw3books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class NfW3BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(NfW3BooksApplication.class, args);
    }

    @Bean
    public WebClient getWebClient() {
        return WebClient.create();
    }

}
