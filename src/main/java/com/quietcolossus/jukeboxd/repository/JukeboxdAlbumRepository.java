package com.quietcolossus.jukeboxd.repository;

import com.quietcolossus.jukeboxd.model.JukeboxdAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JukeboxdAlbumRepository extends JpaRepository<JukeboxdAlbum, Long> {
    // Optional: add custom query methods, e.g. find by title
    List<JukeboxdAlbum> findByTitleContainingIgnoreCase(String title);
    List<JukeboxdAlbum> findByArtistId(Long artistId);
}
