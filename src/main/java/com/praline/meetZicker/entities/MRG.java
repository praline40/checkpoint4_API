package com.praline.meetZicker.entities;

import com.praline.meetZicker.abs.IGetId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.SharePermission;

// MRG = Musician that Research a Group

@Include(type = "MRGs")
@SharePermission
@Entity
public class MRG implements IGetId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many GRM can research to the same style - many GRM to one style
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "s_id", nullable = false)
    private Style style;

    @Column(nullable = false)
    private int age_moy_min; // age min recherché (pour un groupe on fera une moyenne de l'âge des musiciens)

    @Column(nullable = false)
    private int age_moy_max; // age max recherché

    private boolean sex; // sexe recherché

    @ManyToMany(mappedBy = "groups_researches")
    private List<Musician> mucicians = new ArrayList<>(); // pour récupérer tous les musiciens ayant fait cette meme recherche de groupe


    /******* Getters / Setters **********/
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public int getAge_min() {
        return age_moy_min;
    }

    public void setAge_min(int age_min) {
        this.age_moy_min = age_min;
    }

    public int getAge_max() {
        return age_moy_max;
    }

    public void setAge_max(int age_max) {
        this.age_moy_max = age_max;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public List<Musician> getMucicians() {
        return mucicians;
    }

    public void setMucicians(List<Musician> mucicians) {
        this.mucicians = mucicians;
    }
}
