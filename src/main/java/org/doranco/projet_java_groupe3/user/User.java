package org.doranco.projet_java_groupe3.user;

import lombok.*;

import javax.persistence.*;

import org.doranco.projet_java_groupe3.habitation.Habitation;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id @Column(length = 30)
    private String username;

    private String prenom;
    private String email;
    private String phone;
    private String password;
    private String role;

    @OneToMany (mappedBy = "user")
    private List<Habitation> habitations = new ArrayList<>();
}
