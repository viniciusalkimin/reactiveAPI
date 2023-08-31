package com.api.webflux.reactiveAPI.domain.playlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document(collection = "playlist")
@ToString
public class Playlist {

    @Id
    private String id;

    private String name;
}
