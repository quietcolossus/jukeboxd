package com.quietcolossus.jukeboxd.service;

import com.quietcolossus.jukeboxd.exception.AlbumNotFoundException;
import com.quietcolossus.jukeboxd.model.JukeboxdAlbum;
import com.quietcolossus.jukeboxd.repository.JukeboxdAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JukeboxdAlbumService {
    private final JukeboxdAlbumRepository jukeboxdAlbumRepository;

    @Autowired
    public JukeboxdAlbumService(JukeboxdAlbumRepository jukeboxdAlbumRepository) {
        this.jukeboxdAlbumRepository = jukeboxdAlbumRepository;
    }

    public JukeboxdAlbum addAlbum(JukeboxdAlbum album) {
        return jukeboxdAlbumRepository.save(album);
    }

    public List<JukeboxdAlbum> findAllAlbums() {
        return jukeboxdAlbumRepository.findAll();
    }


    public List<JukeboxdAlbum> findAllAlbumsByArtist(Long artistId) {
        return jukeboxdAlbumRepository.findById(artistId).stream().toList();
    }

    public JukeboxdAlbum updateAlbum(JukeboxdAlbum album) {
        return jukeboxdAlbumRepository.save(album);
    }

    public JukeboxdAlbum findAlbumById(Long id) {
        return jukeboxdAlbumRepository.findById(id)
                .orElseThrow(() -> new AlbumNotFoundException("Album by id " + id + " was not found"));
    }

    public void deleteAlbum(Long id) {
        jukeboxdAlbumRepository.deleteById(id);
    }
}
