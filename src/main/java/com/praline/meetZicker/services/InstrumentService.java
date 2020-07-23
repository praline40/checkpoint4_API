package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.InstrumentRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.Instrument;


@Service
public class InstrumentService extends AbstractService<Instrument> {

    InstrumentRepository repository;
    public InstrumentService (InstrumentRepository repository) {
        super(repository);
        this.repository=repository;
    }
}




  