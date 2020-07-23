package com.praline.meetZicker.controllers;

import com.praline.meetZicker.entities.Musician;
import com.praline.meetZicker.services.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicians")
public class MusicianController {
    @Autowired
    MusicianService service;

    @GetMapping()
    public List<Musician> getMusician() { return service.getAll();}

    @GetMapping("/{id}")
    public Musician getMusicianById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping()
    public Musician save(@RequestBody Musician musician) { return service.save(musician); }

    @PatchMapping("/{id}")
    public Musician update(@RequestBody Musician musician, @PathVariable  Long id) { return service.update(musician,id); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) { service.delete(id);}

}


