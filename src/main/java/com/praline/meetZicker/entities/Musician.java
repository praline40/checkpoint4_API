package com.praline.meetZicker.entities;

import com.praline.meetZicker.abs.IGetId;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.SharePermission;

@Include(type = "musicians")
@SharePermission
@Entity
public class Musician implements IGetId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String surname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreatedDate
    private Date created;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private boolean sex;


    @ManyToMany
    @JoinTable(name = "musician_town",
            joinColumns = @JoinColumn(name = "m_id"),
            inverseJoinColumns = @JoinColumn(name = "t_id"))
    private List<Town> towns = new ArrayList<>(); // Liste des villes où le musicien est dispo

    @ManyToMany
    @JoinTable(name = "musician_style",
            joinColumns = @JoinColumn(name = "m_id"),
            inverseJoinColumns = @JoinColumn(name = "s_id"))
    private List<Style> styles = new ArrayList<>(); // Liste des styles que joue le musicien

    @ManyToMany
    @JoinTable(name = "musician_instrument",
            joinColumns = @JoinColumn(name = "m_id"),
            inverseJoinColumns = @JoinColumn(name = "i_id"))
    private List<Instrument> instruments = new ArrayList<>(); // Liste des instruments que joue le musicien

    @ManyToMany
    @JoinTable(name = "musician_group",
            joinColumns = @JoinColumn(name = "m_id"),
            inverseJoinColumns = @JoinColumn(name = "g_id"))
    private List<Group> groups = new ArrayList<>(); // Liste des groupes dans lesquels joue le musicien

    @ManyToMany
    @JoinTable(name = "musician_mrm",
            joinColumns = @JoinColumn(name = "m_id"),
            inverseJoinColumns = @JoinColumn(name = "mrm_id"))
    private List<MRM> musicians_researches = new ArrayList<>(); // Pour récupérer toutes les recherches de musiciens du mucicien

    @ManyToMany
    @JoinTable(name = "musician_mrg",
            joinColumns = @JoinColumn(name = "m_id"),
            inverseJoinColumns = @JoinColumn(name = "mrg_id"))
    private List<MRG> groups_researches = new ArrayList<>(); // Pour récupérer toutes les recherches de groupes du mucicien

    @OneToMany(mappedBy = "musician", cascade = CascadeType.ALL)
    private List<MusicianPicture> pictures; // récupérer les pictures du musicien

    /******* Getters / Setters **********/
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
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

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }



    public List<MusicianPicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<MusicianPicture> pictures) {
        this.pictures = pictures;
    }
}
