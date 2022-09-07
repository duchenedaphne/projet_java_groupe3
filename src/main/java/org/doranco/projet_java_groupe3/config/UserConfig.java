package org.doranco.projet_java_groupe3.config;

import org.doranco.projet_java_groupe3.dao.UserRepository;
import org.doranco.projet_java_groupe3.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    private final UserRepository userRepository;

    public UserConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    CommandLineRunner initUser() {
        return args -> {
            User david = userRepository.save(new User("david", "David", "david@ouinon.fr", "0102030405", "1337", "admin", null));
            User daphne = userRepository.save(new User("daphne", "Daphne", "daphne@ouinon.fr", "0102030406", "1337", "admin", null));
            User nadine = userRepository.save(new User("nadine", "nadine", "nadine@ouinon.fr", "0102030407", "1337", "admin", null));
            User helene = userRepository.save(new User("helene", "Helene", "helene@situveux.fr", "0102030408", "1337", "proprietaire", null));
            User mortimer = userRepository.save(new User("mortimer", "Mortimer", "mortimer@henry.fr", "0102030754", "1337", "user", null));
        };
    }
}
