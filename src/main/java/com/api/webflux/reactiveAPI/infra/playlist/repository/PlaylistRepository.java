package com.api.webflux.reactiveAPI.infra.playlist.repository;


import com.api.webflux.reactiveAPI.domain.playlist.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
