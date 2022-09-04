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

    @OneToMany(mappedBy = "user")
    private List<Habitation> habitations = new ArrayList<>();
    
  /*  
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    */
/*
    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Authority> authorities;
*/
/*
    public User(String username, String prenom, String email, String phone) {
        this.username = username;
        this.prenom=prenom;
        this.email = email;
        this.phone = phone;
        
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
    }
    */

}
