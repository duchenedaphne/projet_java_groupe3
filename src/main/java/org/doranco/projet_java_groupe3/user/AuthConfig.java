package org.doranco.projet_java_groupe3.user;

import org.doranco.projet_java_groupe3.dao.UserRepository;
import org.doranco.projet_java_groupe3.models.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class AuthConfig {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthConfig(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner initAuth() {
        return args -> {
            User user_admin = userRepository.save(new User("admin",passwordEncoder.encode("admin")));
            User user_proprio = userRepository.save(new User("proprio",passwordEncoder.encode("proprio")));
            List<User> users = userRepository.findAll();

            Authority habitation_write = authorityRepository.save(new Authority("habitation:write"));
            Authority habitation_read = authorityRepository.save(new Authority("habitation:read"));
            Authority habitation_delete = authorityRepository.save(new Authority("habitation:delete"));

            Authority user_write = authorityRepository.save(new Authority("user:write"));
            Authority user_read = authorityRepository.save(new Authority("user:read"));
            Authority user_delete = authorityRepository.save(new Authority("user:delete"));

            Authority role_admin = authorityRepository.save(new Authority("ROLE_ADMIN"));
            Authority role_proprietaire = authorityRepository.save(new Authority("ROLE_PROPRIETAIRE"));
            Authority role_user = authorityRepository.save(new Authority("ROLE_USER"));

            role_admin.getUsers().add(user_admin);
            authorityRepository.save(role_admin);
            role_proprietaire.getUsers().add(user_proprio);
            authorityRepository.save(role_proprietaire);

            habitation_write.getUsers().add(user_admin);
            habitation_write.getUsers().add(user_proprio);
            authorityRepository.save(habitation_write);

            habitation_read.getUsers().add(user_admin);
            habitation_read.getUsers().add(user_proprio);
            authorityRepository.save(habitation_read);

            user_write.getUsers().add(user_admin);
            authorityRepository.save(habitation_write);

            habitation_delete.getUsers().add(user_admin);
            user_delete.getUsers().add(user_admin);
            authorityRepository.save(habitation_delete);
        };
    }
}
