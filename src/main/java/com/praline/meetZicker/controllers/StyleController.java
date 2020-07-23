package com.praline.meetZicker.controllers;

import com.praline.meetZicker.entities.Style;
import com.praline.meetZicker.services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/styles")
public class StyleController {
    @Autowired
    StyleService service;

    @GetMapping()
    public List<Style> getStyle() { return service.getAll();}

    @GetMapping("/{id}")
    public Style getStyleById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping()
    public Style save(@RequestBody Style style) { return service.save(style); }

    @PatchMapping("/{id}")
    public Style update(@RequestBody Style style, @PathVariable  Long id) { return service.update(style,id); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) { service.delete(id);}

}


