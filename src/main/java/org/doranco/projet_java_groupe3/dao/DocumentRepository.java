package org.doranco.projet_java_groupe3.dao;

import org.doranco.projet_java_groupe3.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, String> {
    
}
