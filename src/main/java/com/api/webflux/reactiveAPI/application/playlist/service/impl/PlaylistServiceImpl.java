package com.api.webflux.reactiveAPI.application.playlist.service.impl;

import com.api.webflux.reactiveAPI.application.playlist.service.PlaylistService;
import com.api.webflux.reactiveAPI.domain.playlist.Playlist;
import com.api.webflux.reactiveAPI.infra.playlist.repository.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository repository;
    @Override
    public Flux<Playlist> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Playlist> fyndById(String id) {
       return repository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playlist) {
        return repository.save(playlist);
    }
}
