package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.MRMRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.MRM;


@Service
public class MRMService extends AbstractService<MRM> {

    MRMRepository repository;
    public MRMService (MRMRepository repository) {
        super(repository);
        this.repository=repository;
    }
}
