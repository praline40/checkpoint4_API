package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.TownRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.Town;


@Service
public class TownService extends AbstractService<Town> {

    TownRepository repository;
    public TownService (TownRepository repository) {
        super(repository);
        this.repository=repository;
    }
}

