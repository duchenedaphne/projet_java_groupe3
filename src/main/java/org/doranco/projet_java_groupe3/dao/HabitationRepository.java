package org.doranco.projet_java_groupe3.dao;

import org.doranco.projet_java_groupe3.models.Habitation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface HabitationRepository extends JpaRepository<Habitation, String> {

    List<Habitation> findHabitationByPrixLessThan(@PathVariable(name = "prix") double prix);

    List<Habitation> findHabitationByDepartement(@PathVariable(name = "departement") int departement);

    List<Habitation> findHabitationBySuperficie(@PathVariable(name = "superficie") int superficie);
    
    // Habitation findHabitationByUsername(@PathVariable(name = "username") String username);

}
