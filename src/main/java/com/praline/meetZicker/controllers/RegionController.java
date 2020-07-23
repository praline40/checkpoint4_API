package com.praline.meetZicker.controllers;

import com.praline.meetZicker.entities.Region;
import com.praline.meetZicker.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    RegionService service;

    @GetMapping()
    public List<Region> getRegion() { return service.getAll();}

    @GetMapping("/{id}")
    public Region getRegionById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping()
    public Region save(@RequestBody Region region) { return service.save(region); }

    @PatchMapping("/{id}")
    public Region update(@RequestBody Region region, @PathVariable  Long id) { return service.update(region,id); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) { service.delete(id);}

}


