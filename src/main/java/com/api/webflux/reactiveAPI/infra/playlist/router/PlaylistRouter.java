package com.api.webflux.reactiveAPI.infra.playlist.router;

import com.api.webflux.reactiveAPI.infra.playlist.handler.PlaylistHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class PlaylistRouter {

    @Bean
    public RouterFunction<ServerResponse> route(PlaylistHandler playlistHandler) {
        return RouterFunctions
                .route(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::findAll)
                .andRoute(GET("/playlist/{id}").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::findOne)
                .andRoute(GET("/playlist").and(accept(MediaType.APPLICATION_JSON)), playlistHandler::saveOne);
    }
}
