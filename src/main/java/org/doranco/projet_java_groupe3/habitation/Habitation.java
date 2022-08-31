package org.doranco.projet_java_groupe3.habitation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.doranco.projet_java_groupe3.photo.Photo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Habitation {
    
    @Id @Column(length = 30)
    private String id;

    private String nom;
    private EnumHabitation type;
    private String adresse;
    private int departement;
    private double superficie;
    private double prix;
    private String longitude;
    private String latitude;
    private String etat;

    @OneToMany(mappedBy = "habitation")
    private List<Photo> photos = new ArrayList<>();

}
