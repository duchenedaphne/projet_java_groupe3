package org.doranco.projet_java_groupe3.habitation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

public interface HabitationRepository extends JpaRepository<Habitation, String> {

    Page<Habitation> findHabitationByPrixLessThan(@PathVariable(name = "prix") double prix, Pageable pageable);

    Page<Habitation> findHabitationByDepartement(@PathVariable(name = "departement") int departement, Pageable pageable);
    
    // Habitation findHabitationByUsername(@PathVariable(name = "username") String username);

}
