package com.quietcolossus.jukeboxd.controller;

import com.quietcolossus.jukeboxd.model.JukeboxdAlbum;
import com.quietcolossus.jukeboxd.model.JukeboxdUser;
import com.quietcolossus.jukeboxd.service.JukeboxdAlbumService;
import com.quietcolossus.jukeboxd.service.JukeboxdUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class JukeboxdUserController {

    private final JukeboxdUserService jukeboxdUserService;

    public JukeboxdUserController(JukeboxdUserService jukeboxdUserService) {
        this.jukeboxdUserService = jukeboxdUserService;
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<JukeboxdUser>> getAllUsers() {
        List<JukeboxdUser> users = jukeboxdUserService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<JukeboxdUser> getUserById(@PathVariable Long id) {
        JukeboxdUser user = jukeboxdUserService.findUserById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/add")
    public ResponseEntity<JukeboxdUser> addUser(@RequestBody JukeboxdUser user) {
        JukeboxdUser newUser = jukeboxdUserService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<JukeboxdUser> updateUser(@RequestBody JukeboxdUser user) {
        JukeboxdUser updatedUser = jukeboxdUserService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        jukeboxdUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
