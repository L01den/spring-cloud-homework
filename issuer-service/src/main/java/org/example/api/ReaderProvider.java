package org.example.api;

import org.example.Book;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by Lorden on 08.02.2024
 */
@Service
public class BookProvider {

    private final WebClient webClient;

    public BookProvider(ReactorLoadBalancerExchangeFilterFunction loadBalancerExchangeFilterFunction) {
        webClient = WebClient.builder()
                .filter(loadBalancerExchangeFilterFunction)
                .build();
    }

    public Book getRandomBook() {
        Book randomBook = webClient.get()
            .uri("http://book-service/book/random")
            .retrieve()
            .bodyToMono(Book.class)
            .block();
        return randomBook;
    }
}
