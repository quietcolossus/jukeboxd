package com.quietcolossus.jukeboxd.controller;

import com.quietcolossus.jukeboxd.model.JukeboxdAlbum;
import com.quietcolossus.jukeboxd.model.JukeboxdArtist;
import com.quietcolossus.jukeboxd.service.JukeboxdArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class JukeboxdArtistController {
    private final JukeboxdArtistService jukeboxdArtistService;

    public JukeboxdArtistController(JukeboxdArtistService jukeboxdArtistService) {
        this.jukeboxdArtistService = jukeboxdArtistService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JukeboxdArtist>> getAllArtists () {
        List<JukeboxdArtist> artists = jukeboxdArtistService.findAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @PostMapping("/batchAdd")
    public ResponseEntity<List<JukeboxdArtist>> addAlbums(@RequestBody List<JukeboxdArtist> artists) {
        List<JukeboxdArtist> savedArtists = jukeboxdArtistService.saveAll(artists);
        return ResponseEntity.ok(savedArtists);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<JukeboxdArtist> getArtistById (@PathVariable("id") Long id) {
        JukeboxdArtist artist = jukeboxdArtistService.findArtistById(id);
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JukeboxdArtist> addArtist(@RequestBody JukeboxdArtist artist) {
        JukeboxdArtist newArtist = jukeboxdArtistService.addArtist(artist);
        return new ResponseEntity<>(newArtist, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<JukeboxdArtist> updateArtist(@RequestBody JukeboxdArtist artist) {
        JukeboxdArtist updatedArtist = jukeboxdArtistService.updateArtist(artist);
        return new ResponseEntity<>(updatedArtist, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArtist(@PathVariable("id") Long id) {
        jukeboxdArtistService.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
