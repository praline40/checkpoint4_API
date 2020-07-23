package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.MusicianRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.Musician;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static java.util.Collections.emptyList;

@Service
public class MusicianService extends AbstractService<Musician> implements UserDetailsService {
    MusicianRepository repository;

    public MusicianService (MusicianRepository repository) {
        super(repository);
        this.repository=repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Musician musician = repository.findByEmail(username);
        if (musician == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(musician.getEmail(), musician.getPassword(), emptyList());
    }
}

