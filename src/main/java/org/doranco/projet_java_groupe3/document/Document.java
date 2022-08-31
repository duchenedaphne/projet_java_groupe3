package org.doranco.projet_java_groupe3.document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Document {
    
    @Id @Column(length = 30)
    private String id;
    private EnumDocument type;

}
