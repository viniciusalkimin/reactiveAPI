package com.api.webflux.reactiveAPI.application.playlist.service;

import com.api.webflux.reactiveAPI.domain.playlist.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlaylistService {

    Flux<Playlist> findAll();

    Mono<Playlist> fyndById(String id);

    Mono<Playlist> save(Playlist playlist);
}
