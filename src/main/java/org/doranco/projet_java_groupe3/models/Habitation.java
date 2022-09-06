package org.doranco.projet_java_groupe3.models;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user; // => String USER_USERNAME en BDD
}
