package com.api.webflux.reactiveAPI.infra.playlist.controller;

import com.api.webflux.reactiveAPI.application.playlist.service.PlaylistService;
import com.api.webflux.reactiveAPI.domain.playlist.Playlist;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/playlists")
public class PlaylistController{

    private PlaylistService playlistService;

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Playlist>> getById(@PathVariable String id) {
        return ResponseEntity.ok(playlistService.fyndById(id));
    }

    @GetMapping()
    public ResponseEntity<Flux<Playlist>> getAll(){
        return ResponseEntity.ok(playlistService.findAll());
    }

    public ResponseEntity<Mono<Playlist>> saveOne(@RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.save(playlist));
    }
}
