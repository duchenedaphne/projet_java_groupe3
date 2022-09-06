package org.doranco.projet_java_groupe3.dao;

import org.doranco.projet_java_groupe3.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, String> {
    
}
