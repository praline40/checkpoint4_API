package com.praline.meetZicker.entities;

import com.praline.meetZicker.abs.IGetId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.SharePermission;

import java.sql.Date;

@Include(type = "Musician_pictures")
@SharePermission
@Entity
public class MusicianPicture implements IGetId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many pictures can belong to the same musician - many pictures to one musician
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "m_id", nullable = false)
    private Musician musician;

    private String lieu;

    private Date date;

    // Many pictures can belong to the same concert - many pictures to one concert
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "c_id", nullable = true) // peut être null si c'est une photo lors d'une répet du musicien
    private Concert concert;

    /******* Getters / Setters **********/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Musician getMusician() {
        return musician;
    }

    public void setMusician(Musician musician) {
        this.musician = musician;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
