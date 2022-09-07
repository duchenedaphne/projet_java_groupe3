package org.doranco.projet_java_groupe3.config;

import org.doranco.projet_java_groupe3.dao.HabitationRepository;
import org.doranco.projet_java_groupe3.models.EnumHabitation;
import org.doranco.projet_java_groupe3.models.Habitation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HabitationConfig {

    private final HabitationRepository habitationRepository;

    public HabitationConfig(HabitationRepository habitationRepository) {
        this.habitationRepository = habitationRepository;
    }

    @Bean
    CommandLineRunner initHabitation() {
        return args -> {
            Habitation habitationUn = habitationRepository.save(new Habitation("001", "Palace de djerbien riche", EnumHabitation.APPARTEMENT, null, 91, 550, 750, null, null,null,null, null));
            Habitation habitationDeux = habitationRepository.save(new Habitation("002", "Cabanon post-moderne", EnumHabitation.APPARTEMENT, null, 75, 30, 13000, null, null,null,null, null));
            Habitation habitationTrois = habitationRepository.save(new Habitation("003", "Hutte de post²-moderne", EnumHabitation.APPARTEMENT, null, 93, 15, 713, null, null,null,null, null));
            Habitation habitationQuatre = habitationRepository.save(new Habitation("004", "Atelier post³-moderne", EnumHabitation.APPARTEMENT, null, 92, 137, 800, null, null,null,null, null));
        };
    }
}
