package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.GRMRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.GRM;


@Service
public class GRMService extends AbstractService<GRM> {

    GRMRepository repository;
    public GRMService (GRMRepository repository) {
        super(repository);
        this.repository=repository;
    }
}
