package com.api.webflux.reactiveAPI.infra.playlist.handler;

import com.api.webflux.reactiveAPI.application.playlist.service.PlaylistService;
import com.api.webflux.reactiveAPI.domain.playlist.Playlist;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@AllArgsConstructor
public class PlaylistHandler {

    private PlaylistService playlistService;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.findAll(), Playlist.class);
    }

    public Mono<ServerResponse> findOne(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.fyndById(id), Playlist.class);
    }

    public Mono<ServerResponse> saveOne(ServerRequest serverRequest) {
        final Mono<Playlist> playlist = serverRequest.bodyToMono(Playlist.class);
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(playlistService::save), Playlist.class));
    }
}
