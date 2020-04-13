package ru.iapparov.plain.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iapparov.plain.client.GreetingAsyncRestClient;
import ru.iapparov.plain.model.Greeting;

import java.util.concurrent.CompletableFuture;

@RestController
@Profile("async")
public class CompletableController {

    private GreetingAsyncRestClient restClient;
    public CompletableController(GreetingAsyncRestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/hello")
    public CompletableFuture<Greeting> handle() {
        return restClient.getHooiting();
    }

}
