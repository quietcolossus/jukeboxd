package com.quietcolossus.jukeboxd.service;

import com.quietcolossus.jukeboxd.exception.ArtistNotFoundException;
import com.quietcolossus.jukeboxd.model.JukeboxdAlbum;
import com.quietcolossus.jukeboxd.model.JukeboxdArtist;
import com.quietcolossus.jukeboxd.model.JukeboxdArtist;
import com.quietcolossus.jukeboxd.repository.JukeboxdArtistRepository;
import com.quietcolossus.jukeboxd.repository.JukeboxdArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JukeboxdArtistService {
    private final JukeboxdArtistRepository jukeboxdArtistRepository;

    @Autowired
    public JukeboxdArtistService(JukeboxdArtistRepository jukeboxdArtistRepository) {
        this.jukeboxdArtistRepository = jukeboxdArtistRepository;
    }

    public JukeboxdArtist addArtist(JukeboxdArtist artist) {
        return jukeboxdArtistRepository.save(artist);
    }

    public List<JukeboxdArtist> findAllArtists() {
        return jukeboxdArtistRepository.findAll();
    }

    public JukeboxdArtist updateArtist(JukeboxdArtist artist) {
        return jukeboxdArtistRepository.save(artist);
    }

    public JukeboxdArtist findArtistById(Long id) {
        return jukeboxdArtistRepository.findById(id)
                .orElseThrow(() -> new ArtistNotFoundException("Artist by id " + id + " was not found"));
    }
    public List<JukeboxdArtist> saveAll(List<JukeboxdArtist> artists) {
        return jukeboxdArtistRepository.saveAll(artists);
    }

    public void deleteArtist(Long id) {
        jukeboxdArtistRepository.deleteById(id);
    }
}
