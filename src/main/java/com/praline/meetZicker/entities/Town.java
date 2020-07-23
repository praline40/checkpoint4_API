package com.praline.meetZicker.entities;

import com.praline.meetZicker.abs.IGetId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.SharePermission;


@Include(type = "towns")
@SharePermission
@Entity
public class Town implements IGetId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many towns can belong to the same region - many towns to one region
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "r_id", nullable = false)
    private Region region;

    @OneToMany(mappedBy = "town", cascade = CascadeType.ALL)
    private List<Concert> concerts; // récupérer les concerts de la ville

    @ManyToMany(mappedBy = "towns")
    private List<Musician> musicians = new ArrayList<>(); // Pour récupérer tous les musiciens de la ville

    @ManyToMany(mappedBy = "towns")
    private List<Group> groups = new ArrayList<>(); // Pour récupérer tous les groupes de la ville



    /******* Getters / Setters **********/
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
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
