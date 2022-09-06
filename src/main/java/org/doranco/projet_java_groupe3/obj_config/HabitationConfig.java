package org.doranco.projet_java_groupe3.obj_config;

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
            Habitation habitationUn = habitationRepository.save(new Habitation("001", "Cabane de blédard riche", EnumHabitation.APPARTEMENT, null, 30, 30, 30, null, null,null,null, null));
            Habitation habitationDeux = habitationRepository.save(new Habitation("002", "Cabane de blédard riche", EnumHabitation.APPARTEMENT, null, 30, 30, 30, null, null,null,null, null));
            Habitation habitationTrois = habitationRepository.save(new Habitation("003", "Cabane de blédard riche", EnumHabitation.APPARTEMENT, null, 30, 30, 30, null, null,null,null, null));
            Habitation habitationQuatre = habitationRepository.save(new Habitation("004", "Cabane de blédard riche", EnumHabitation.APPARTEMENT, null, 30, 30, 30, null, null,null,null, null));
        };
    }
}
