package com.praline.meetZicker.entities;

import com.praline.meetZicker.abs.IGetId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.SharePermission;


// GRG = Group that Research a Group

@Include(type = "GRGs")
@SharePermission
@Entity
public class GRG implements IGetId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many GRM can research to the same style - many GRM to one style
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "s_id", nullable = false)
    private Style style;

    @Column(nullable = false)
    private int age_min; // age min recherché (pour un groupe on fera une moyenne de l'âge des musiciens)

    @Column(nullable = false)
    private int age_max; // age max recherché

    @ManyToMany(mappedBy = "groups_researches")
    private List<Group> groups = new ArrayList<>(); // pour récupérer tous les groupes ayant fait cette recherche



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
        return age_min;
    }

    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }

    public int getAge_max() {
        return age_max;
    }

    public void setAge_max(int age_max) {
        this.age_max = age_max;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
