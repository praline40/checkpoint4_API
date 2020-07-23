package com.praline.meetZicker.controllers;

import com.praline.meetZicker.entities.GRM;
import com.praline.meetZicker.services.GRMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GRM")
public class GRMController {
    @Autowired
    GRMService service;

    @GetMapping()
    public List<GRM> getGRM() { return service.getAll();}

    @GetMapping("/{id}")
    public GRM getGRMById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping()
    public GRM save(@RequestBody GRM grm) { return service.save(grm); }

    @PatchMapping("/{id}")
    public GRM update(@RequestBody GRM grm, @PathVariable  Long id) { return service.update(grm,id); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) { service.delete(id);}

}


