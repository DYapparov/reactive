package ru.iapparov.reactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import ru.iapparov.reactive.client.GreetingWebClient;
import ru.iapparov.reactive.model.Greeting;

@Configuration
public class RouterConfiguration {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingWebClient greetingWebClient) {

        return RouterFunctions
                .route(
                        RequestPredicates.GET("/hello"),
                        serverRequest -> ServerResponse.ok()
//                                .contentType(MediaType.APPLICATION_STREAM_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(Flux.mergeSequential(greetingWebClient.getHooiting(), greetingWebClient.getResult()), Greeting.class)
                );
    }
}
