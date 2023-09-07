package com.api.webflux.reactiveAPI.infra.playlist.controller;

import com.api.webflux.reactiveAPI.application.playlist.service.PlaylistService;
import com.api.webflux.reactiveAPI.domain.playlist.Playlist;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.time.LocalDateTime;

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

    @PostMapping
    public ResponseEntity<Mono<Playlist>> saveOne(@RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.save(playlist));
    }

    @GetMapping(value="/playlist/webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistByWebflux(){

        System.out.println("---Start get Playlists by WEBFLUX--- " + LocalDateTime.now());
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> playlistFlux = playlistService.findAll();

        return Flux.zip(interval, playlistFlux);

    }
}
