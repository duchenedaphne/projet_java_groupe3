package org.doranco.projet_java_groupe3.photo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.doranco.projet_java_groupe3.habitation.Habitation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Photo {

    @Id @Column(length = 30)
    private String id;
    private String path;

    @ManyToOne
    private Habitation habitation;
    
}
