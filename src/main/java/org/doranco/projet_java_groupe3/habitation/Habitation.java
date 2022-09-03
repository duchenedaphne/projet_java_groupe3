package org.doranco.projet_java_groupe3.habitation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.doranco.projet_java_groupe3.photo.Photo;
import org.doranco.projet_java_groupe3.user.User;

import lombok.*;

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

    private String photo;

    @ManyToOne
    private User user; // => String USER_USERNAME en BDD
/*
    @OneToMany(mappedBy = "habitation")
    private List<Photo> photos = new ArrayList<>();
*/
}
