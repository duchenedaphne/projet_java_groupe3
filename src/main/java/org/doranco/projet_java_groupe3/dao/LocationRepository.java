package org.doranco.projet_java_groupe3.dao;

import org.doranco.projet_java_groupe3.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, String> {
    
}
