package org.doranco.projet_java_groupe3.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.doranco.projet_java_groupe3.models.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
@NoArgsConstructor
public class Authority {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    @ManyToMany
    @JoinTable(
            name = "role",
            joinColumns = @JoinColumn(name = "id_auth"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> users ;

    public Authority(String name) {
        this.name = name;
        users = new ArrayList<>();
    }
}