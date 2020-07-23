package com.praline.meetZicker.entities;

import com.praline.meetZicker.abs.IGetId;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.annotation.SharePermission;

@Include(type = "concerts")
@SharePermission
@Entity
public class Concert implements IGetId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(nullable = false)
    private Date date;

    /* Seuls des groupes peuvent se présenter sur scène - donc un musicien qui joue tout seul, aura quand même un nom de groupe,
    ie un groupe peut n'avoir qu'un seul musicien */
    @ManyToMany(mappedBy = "concerts")
    private List<Group> groups = new ArrayList<>(); // Récupérer tous les groupes lors de ce concert (il peut y en avoir plusieurs sur la même scène)

    // Many concerts can belong to the same town - many concerts to one town
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "t_id", nullable = false)
    private Town town;

    @Column(nullable = false)
    private String address; // address

    // Un concert peut avoir plusieurs photos de groupe(s)
    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
    private List<GroupPicture> groupPictures; // récupérer les photos des groupes du concert

    // Un concert peut avoir plusieurs photos de musiciens(s)
    @OneToMany(mappedBy = "concert", cascade = CascadeType.ALL)
    private List<MusicianPicture> musicianPictures; // récupérer les photos des musiciens du concert

    /******* Getters / Setters **********/
    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<GroupPicture> getGroupPictures() {
        return groupPictures;
    }

    public void setGroupPictures(List<GroupPicture> groupPictures) {
        this.groupPictures = groupPictures;
    }

    public List<MusicianPicture> getMusicianPictures() {
        return musicianPictures;
    }

    public void setMusicianPictures(List<MusicianPicture> musicianPictures) {
        this.musicianPictures = musicianPictures;
    }
}
