package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.MRGRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.MRG;


@Service
public class MRGService extends AbstractService<MRG> {

    MRGRepository repository;
    public MRGService (MRGRepository repository) {
        super(repository);
        this.repository=repository;
    }
}
