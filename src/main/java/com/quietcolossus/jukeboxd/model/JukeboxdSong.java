package com.quietcolossus.jukeboxd.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public record JukeboxdSong(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long songId,

        String title,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "artist_id", nullable = true)
        JukeboxdArtist artist,

        String description,

        @ElementCollection
        List<Long> reviews,

        @ElementCollection
        List<String> genres,

        String spotifyUrl,
        LocalDate releaseDate,
        String coverImageUrl,
        String lyrics
) {}
