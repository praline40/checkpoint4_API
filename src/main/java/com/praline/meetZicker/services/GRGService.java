package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.GRGRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.GRG;


@Service
public class GRGService extends AbstractService<GRG> {

    GRGRepository repository;
    public GRGService (GRGRepository repository) {
        super(repository);
        this.repository=repository;
    }
}
