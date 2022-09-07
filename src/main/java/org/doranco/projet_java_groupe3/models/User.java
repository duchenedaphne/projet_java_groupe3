package org.doranco.projet_java_groupe3.models;

import lombok.*;
// import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @Column(length = 30)
    private String username;

    private String prenom;
    private String email;
    private String phone;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Habitation> habitations = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}