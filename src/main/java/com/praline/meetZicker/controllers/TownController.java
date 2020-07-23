package com.praline.meetZicker.controllers;

import com.praline.meetZicker.entities.Town;
import com.praline.meetZicker.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/towns")
public class TownController {
    @Autowired
    TownService service;

    @GetMapping()
    public List<Town> getTown() { return service.getAll();}

    @GetMapping("/{id}")
    public Town getTownById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping()
    public Town save(@RequestBody Town town) { return service.save(town); }

    @PatchMapping("/{id}")
    public Town update(@RequestBody Town town, @PathVariable  Long id) { return service.update(town,id); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) { service.delete(id);}

}


