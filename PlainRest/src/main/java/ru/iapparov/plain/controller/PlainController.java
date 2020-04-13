package ru.iapparov.plain.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.iapparov.plain.client.GreetingRestClient;
import ru.iapparov.plain.model.Greeting;

@RestController
@Profile("plain")
public class PlainController {

    private GreetingRestClient restClient;
    public PlainController(GreetingRestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/hello")
    public Greeting handle() {
        return restClient.getHooiting();
    }

}
