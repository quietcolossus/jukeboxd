package com.quietcolossus.jukeboxd.service;

import com.quietcolossus.jukeboxd.exception.ResourceNotFoundException;
import com.quietcolossus.jukeboxd.model.JukeboxdAlbum;
import com.quietcolossus.jukeboxd.model.JukeboxdUser;
import com.quietcolossus.jukeboxd.repository.JukeboxdAlbumRepository;
import com.quietcolossus.jukeboxd.repository.JukeboxdUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JukeboxdUserService {

    private final JukeboxdUserRepository jukeboxdUserRepository;

    @Autowired
    public JukeboxdUserService(JukeboxdUserRepository jukeboxdUserRepository) {
        this.jukeboxdUserRepository = jukeboxdUserRepository;
    }
    public JukeboxdUser addUser(JukeboxdUser user) {
        return jukeboxdUserRepository.save(user);
    }
    public List<JukeboxdUser> findAllUsers() {
        return jukeboxdUserRepository.findAll();
    }

    public JukeboxdUser findUserById(Long id) {
        return jukeboxdUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Album by id " + id + " was not found"));
    }

    public void deleteUser(Long id)  {
        jukeboxdUserRepository.deleteById(id);
    }

    public JukeboxdUser updateUser(JukeboxdUser user)  {
        return jukeboxdUserRepository.save(user);
    }
}
