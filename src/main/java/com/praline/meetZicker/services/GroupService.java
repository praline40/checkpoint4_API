package com.praline.meetZicker.services;

import com.praline.meetZicker.abs.AbstractService;
import com.praline.meetZicker.repositories.GroupRepository;
import org.springframework.stereotype.Service;
import com.praline.meetZicker.entities.Group;


@Service
public class GroupService extends AbstractService<Group> {

    GroupRepository repository;
    public GroupService (GroupRepository repository) {
        super(repository);
        this.repository=repository;
    }
}

