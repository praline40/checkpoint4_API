package com.praline.meetZicker.controllers;

import com.praline.meetZicker.entities.Concert;
import com.praline.meetZicker.services.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    @Autowired
    ConcertService service;

    @GetMapping()
    public List<Concert> getConcert() { return service.getAll();}

    @GetMapping("/{id}")
    public Concert getConcertById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping()
    public Concert save(@RequestBody Concert concert) { return service.save(concert); }

    @PatchMapping("/{id}")
    public Concert update(@RequestBody Concert concert, @PathVariable  Long id) { return service.update(concert,id); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) { service.delete(id);}

}

