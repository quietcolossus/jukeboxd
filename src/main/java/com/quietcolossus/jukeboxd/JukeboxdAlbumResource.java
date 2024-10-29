package com.quietcolossus.jukeboxd;

import com.quietcolossus.jukeboxd.model.JukeboxdAlbum;
import com.quietcolossus.jukeboxd.service.JukeboxdAlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class JukeboxdAlbumResource {
    private final JukeboxdAlbumService jukeboxdAlbumService;

    public JukeboxdAlbumResource(JukeboxdAlbumService jukeboxdAlbumService) {
        this.jukeboxdAlbumService = jukeboxdAlbumService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JukeboxdAlbum>> getAllAlbums () {
        List<JukeboxdAlbum> albums = jukeboxdAlbumService.findAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<JukeboxdAlbum> getAlbumById (@PathVariable("id") Long id) {
        JukeboxdAlbum album = jukeboxdAlbumService.findAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JukeboxdAlbum> addAlbum(@RequestBody JukeboxdAlbum album) {
        JukeboxdAlbum newAlbum = jukeboxdAlbumService.addAlbum(album);
        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
    }

    @PostMapping("/batchAdd")
    public ResponseEntity<List<JukeboxdAlbum>> addAlbums(@RequestBody List<JukeboxdAlbum> albums) {
        List<JukeboxdAlbum> savedAlbums = jukeboxdAlbumService.saveAll(albums);
        return ResponseEntity.ok(savedAlbums);
    }

    @PutMapping("/update")
    public ResponseEntity<JukeboxdAlbum> updateAlbum(@RequestBody JukeboxdAlbum album) {
        JukeboxdAlbum updatedAlbum = jukeboxdAlbumService.updateAlbum(album);
        return new ResponseEntity<>(updatedAlbum, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable("id") Long id) {
        jukeboxdAlbumService.deleteAlbum(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
