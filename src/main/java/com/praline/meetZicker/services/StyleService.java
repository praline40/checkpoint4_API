package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.StyleRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.Style;


@Service
public class StyleService extends AbstractService<Style> {

    StyleRepository repository;
    public StyleService (StyleRepository repository) {
        super(repository);
        this.repository=repository;
    }
}

