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
public class JukeboxdUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private String passwordHash;
    private String email;

    @ElementCollection
    private List<Long> following;

    @ElementCollection
    private List<Long> followers;
}
