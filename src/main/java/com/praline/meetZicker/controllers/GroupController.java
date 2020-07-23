package com.praline.meetZicker.controllers;

import com.praline.meetZicker.entities.Group;
import com.praline.meetZicker.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    GroupService service;

    @GetMapping()
    public List<Group> getGroup() { return service.getAll();}
    
    @GetMapping("/{id}")
    public Group getGroupById(@PathVariable Long id) { return service.getById(id); }
    
    @PostMapping()
    public Group save(@RequestBody Group group) { return service.save(group); }
    
    @PatchMapping("/{id}")
    public Group update(@RequestBody Group group, @PathVariable  Long id) { return service.update(group,id); }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) { service.delete(id);}

}



