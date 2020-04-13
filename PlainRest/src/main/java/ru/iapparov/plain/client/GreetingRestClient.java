package ru.iapparov.plain.client;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.iapparov.plain.model.Greeting;

@Component
@Profile("plain")
public class GreetingRestClient {
    private RestTemplate restTemplate = new RestTemplate();

    public Greeting getResult() {
        return restTemplate.getForObject("http://localhost:5555/greeting", Greeting.class);
    }

    public Greeting getHooiting() {
        return restTemplate.getForObject("http://localhost:5555/hooiting", Greeting.class);
    }
}
