package org.doranco.projet_java_groupe3.location;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Location {
    
    @Id @Column(length = 30)
    private String id;

    private Date dateDebut;
    private Date dateFin;
    private String duree;
}
