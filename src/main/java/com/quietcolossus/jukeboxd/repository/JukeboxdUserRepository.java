package com.quietcolossus.jukeboxd.repository;

import com.quietcolossus.jukeboxd.model.JukeboxdUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JukeboxdUserRepository extends JpaRepository<JukeboxdUser, Long> {
}
