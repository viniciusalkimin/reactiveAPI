package com.api.webflux.reactiveAPI.infra.playlist.dummydata;

import com.api.webflux.reactiveAPI.domain.playlist.Playlist;
import com.api.webflux.reactiveAPI.infra.playlist.repository.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Configuration
@AllArgsConstructor
public class DummyData implements CommandLineRunner {

    private final PlaylistRepository playlistRepository;

    @Override
    public void run(String... args) throws Exception {

    	playlistRepository.deleteAll()
                .thenMany(
                        Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud", "Java 8",
                                "Github", "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
                                .map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
                                .flatMap(playlistRepository::save))
                .subscribe(System.out::println);
    }
}

