package com.quietcolossus.jukeboxd.controller;

import com.quietcolossus.jukeboxd.model.JukeboxdAlbum;
import com.quietcolossus.jukeboxd.service.JukeboxdAlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class JukeboxdAlbumController {
    private final JukeboxdAlbumService jukeboxdAlbumService;

    public JukeboxdAlbumController(JukeboxdAlbumService jukeboxdAlbumService) {
        this.jukeboxdAlbumService = jukeboxdAlbumService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JukeboxdAlbum>> getAllAlbums () {
        List<JukeboxdAlbum> albums = jukeboxdAlbumService.findAllAlbums();
        return ResponseEntity.ok(albums);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<JukeboxdAlbum> getAlbumById (@PathVariable("id") Long id) {
        JukeboxdAlbum album = jukeboxdAlbumService.findAlbumById(id);
        return ResponseEntity.ok(album);
    }
    @GetMapping("/find/artist/{id}")
    public ResponseEntity<List<JukeboxdAlbum>> findAllAlbumsByArtist (@PathVariable("id") Long id) {
        List<JukeboxdAlbum> albumsByArtist = jukeboxdAlbumService.findAllAlbumsByArtist(id);
        return ResponseEntity.ok(albumsByArtist);
    }
    @PostMapping("/add")
    public ResponseEntity<JukeboxdAlbum> addAlbum(@RequestBody JukeboxdAlbum album) {
        JukeboxdAlbum newAlbum = jukeboxdAlbumService.addAlbum(album);
        return ResponseEntity.ok(newAlbum);
    }

    @PostMapping("/batchAdd")
    public ResponseEntity<List<JukeboxdAlbum>> addAlbums(@RequestBody List<JukeboxdAlbum> albums) {
        List<JukeboxdAlbum> savedAlbums = jukeboxdAlbumService.saveAll(albums);
        return ResponseEntity.ok(savedAlbums);
    }

    @PutMapping("/update")
    public ResponseEntity<JukeboxdAlbum> updateAlbum(@RequestBody JukeboxdAlbum album) {
        JukeboxdAlbum updatedAlbum = jukeboxdAlbumService.updateAlbum(album);
        return ResponseEntity.ok(updatedAlbum);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable("id") Long id) {
        jukeboxdAlbumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }
}
