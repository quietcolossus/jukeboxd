package com.quietcolossus.jukeboxd.model;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JukeboxdReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private JukeboxdUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private JukeboxdAlbum album;

    private Integer rating;
    private String text;
    private Integer likes = 0;

    @ElementCollection
    private List<String> tags;

    @ElementCollection
    private List<Long> comments;

    @CreatedDate
    private LocalDateTime date = LocalDateTime.now();
}
