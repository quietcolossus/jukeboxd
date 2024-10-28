package com.quietcolossus.jukeboxd.model;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JukeboxdAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = true)
    private JukeboxdArtist artist;

    private String description;
    private LocalDate releaseDate;
    private Double avgRating;
    private String coverImageUrl;

    @ElementCollection
    private List<Long> reviews;

    @ElementCollection
    private List<String> trackList;

    @ElementCollection
    private List<String> genres;

    private String spotifyUrl;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
