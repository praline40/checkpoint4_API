package com.praline.meetZicker.entities;

import com.praline.meetZicker.abs.IGetId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.SharePermission;

@Include(type = "styles")
@SharePermission
@Entity
public class Style implements IGetId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "styles")
    private List<Musician> musicians = new ArrayList<>();  // récupérer tous les musiciens qui jouent ce style

    @ManyToMany(mappedBy = "styles")
    private List<Group> groups = new ArrayList<>();  // récupérer tous les groupes qui jouent ce style



    /******* Getters / Setters **********/
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Musician> musicians) {
        this.musicians = musicians;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
