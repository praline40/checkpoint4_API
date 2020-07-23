package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.ConcertRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.Concert;


@Service
public class ConcertService extends AbstractService<Concert> {

    ConcertRepository repository;
    public ConcertService (ConcertRepository repository) {
        super(repository);
        this.repository=repository;
    }
}
