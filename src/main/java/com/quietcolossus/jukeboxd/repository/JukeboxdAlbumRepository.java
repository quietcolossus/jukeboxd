package com.quietcolossus.jukeboxd.repository;

import com.quietcolossus.jukeboxd.model.JukeboxdAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(path = "albums") // Exposes endpoint at /albums
public interface JukeboxdAlbumRepository extends JpaRepository<JukeboxdAlbum, Long> {
    // Optional: add custom query methods, e.g. find by title
    List<JukeboxdAlbum> findByTitleContainingIgnoreCase(String title);
}
