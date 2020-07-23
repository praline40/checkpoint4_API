package com.praline.meetZicker.controllers;

import com.praline.meetZicker.entities.Instrument;
import com.praline.meetZicker.services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instruments")
public class InstrumentController {
    @Autowired
    InstrumentService service;

    @GetMapping()
    public List<Instrument> getInstrument() { return service.getAll();}

    @GetMapping("/{id}")
    public Instrument getInstrumentById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping()
    public Instrument save(@RequestBody Instrument instrument) { return service.save(instrument); }

    @PatchMapping("/{id}")
    public Instrument update(@RequestBody Instrument instrument, @PathVariable  Long id) { return service.update(instrument,id); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) { service.delete(id);}

}



