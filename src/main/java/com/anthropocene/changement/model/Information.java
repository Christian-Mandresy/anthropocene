package com.anthropocene.changement.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String titre;

    @Column
    private String auteur;

    @Column
    private String image;

    @Column
    @Temporal(TemporalType.DATE)
    private Date datepublication;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDatepublication() {
        return datepublication;
    }

    public void setDatepublication(Date datepublication) {
        this.datepublication = datepublication;
    }
}
