package org.doranco.projet_java_groupe3.habitation;

import org.doranco.projet_java_groupe3.user.User;
import org.doranco.projet_java_groupe3.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HabitationConfig {

    private final HabitationRepository habitationRepository;
    private final UserRepository userRepository;

    public HabitationConfig(HabitationRepository habitationRepository, UserRepository userRepository) {
        this.habitationRepository = habitationRepository;
        this.userRepository = userRepository;
    }

    @Bean
    CommandLineRunner initUser() {
        return args -> {
            Habitation habitationUn = habitationRepository.save(new Habitation("001", "Cabane de blédard riche", EnumHabitation.APPARTEMENT, null, 30, 30, 30, null, null,null,null, null));
            Habitation habitationDeux = habitationRepository.save(new Habitation("002", "Cabane de blédard riche", EnumHabitation.APPARTEMENT, null, 30, 30, 30, null, null,null,null, null));
            Habitation habitationTrois = habitationRepository.save(new Habitation("003", "Cabane de blédard riche", EnumHabitation.APPARTEMENT, null, 30, 30, 30, null, null,null,null, null));
            Habitation habitationQuatre = habitationRepository.save(new Habitation("004", "Cabane de blédard riche", EnumHabitation.APPARTEMENT, null, 30, 30, 30, null, null,null,null, null));
            User user_admin = userRepository.save(new User("admin", "David", "david@david.fr", "0102030405", "1337", "proprietaire", null));
        };
    }
}
