package ru.iapparov.plain.client;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.iapparov.plain.model.Greeting;

import java.util.concurrent.CompletableFuture;

@Component
@Profile("async")
public class GreetingAsyncRestClient {
    private RestTemplate restTemplate = new RestTemplate();

    public CompletableFuture<Greeting> getResult() {
        return CompletableFuture.completedFuture(restTemplate.getForObject("http://localhost:5555/greeting", Greeting.class));
    }

    @Async
    public CompletableFuture<Greeting> getHooiting() {
        return CompletableFuture.completedFuture(restTemplate.getForObject("http://localhost:5555/hooiting", Greeting.class));
    }
}
