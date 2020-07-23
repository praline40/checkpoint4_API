package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.RegionRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.Region;


@Service
public class RegionService extends AbstractService<Region> {

    RegionRepository repository;
    public RegionService (RegionRepository repository) {
        super(repository);
        this.repository=repository;
    }
}



