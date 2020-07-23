package com.praline.meetZicker.repositories;

import com.praline.meetZicker.entities.Musician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicianRepository extends JpaRepository<Musician, Long> {
    Musician findByEmail(String email);
}
