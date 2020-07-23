package com.praline.meetZicker.entities;

import com.praline.meetZicker.abs.IGetId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.SharePermission;

@Include(type = "groups")
@SharePermission
@Entity
public class Group implements IGetId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "groups")
    private List<Musician> musicians = new ArrayList<>(); // Liste des musiciens du groupe

    @ManyToMany
    @JoinTable(name = "group_town",
            joinColumns = @JoinColumn(name = "g_id"),
            inverseJoinColumns = @JoinColumn(name = "t_id"))
    private List<Town> towns = new ArrayList<>(); // Liste des villes où le groupe répète

    @ManyToMany
    @JoinTable(name = "group_style",
            joinColumns = @JoinColumn(name = "g_id"),
            inverseJoinColumns = @JoinColumn(name = "s_id"))
    private List<Style> styles = new ArrayList<>(); // Liste de tous les styles que joue le groupe

    @ManyToMany
    @JoinTable(name = "group_grm",
            joinColumns = @JoinColumn(name = "g_id"),
            inverseJoinColumns = @JoinColumn(name = "grm_id"))
    private List<GRM> musicians_researches = new ArrayList<>(); // Pour récupérer toutes les recherches de musiciens du groupe

    @ManyToMany
    @JoinTable(name = "group_grg",
            joinColumns = @JoinColumn(name = "g_id"),
            inverseJoinColumns = @JoinColumn(name = "grg_id"))
    private List<GRG> groups_researches = new ArrayList<>(); // Pour récupérer toutes les recherches de groupes du groupe

    @ManyToMany
    @JoinTable(name = "group_concert",
            joinColumns = @JoinColumn(name = "g_id"),
            inverseJoinColumns = @JoinColumn(name = "c_id"))
    private List<Concert> concerts = new ArrayList<>(); // Pour récupérer toutes les concerts du groupe

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<GroupPicture> pictures; // récupérer les pictures du groupe

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

    public List<Town> getTowns() {
        return towns;
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

    public List<GroupPicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<GroupPicture> pictures) {
        this.pictures = pictures;
    }
}
