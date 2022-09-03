package org.doranco.projet_java_groupe3.message;

import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
public class Message {

    @Id @Column(length = 30)
    private String id;
    private Date date;
    
}
