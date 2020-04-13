package ru.iapparov.reactive.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import ru.iapparov.reactive.model.Greeting;

@Component
public class GreetingWebClient {
    private WebClient client = WebClient.create("http://localhost:5555");

    private Mono<ClientResponse> result = client.get()
            .uri("/greeting")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();

    private Mono<ClientResponse> hooiting = client.get()
            .uri("/hooiting")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();

    public Mono<Greeting> getResult() {
        return result.flatMap(res -> res.bodyToMono(Greeting.class));
    }

    public Mono<Greeting> getHooiting() {
        return hooiting.flatMap(res -> res.bodyToMono(Greeting.class));
    }
}
