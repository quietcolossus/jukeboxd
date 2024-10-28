package com.quietcolossus.jukeboxd.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JukeboxdArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistId;

    private String name;
    private String description;

    @ElementCollection
    private List<String> members;

    @ElementCollection
    private List<String> genres;
}

