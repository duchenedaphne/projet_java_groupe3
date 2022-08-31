package org.doranco.projet_java_groupe3.document;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDocumentService {
    
    public Document transmettreDocument(Document document) throws Exception;
    public Document modifierDocument(Document document) throws Exception;

    public Page<Document> afficherDocuments(Pageable pageable) throws Exception;

    public Document detailsDocument(String id) throws Exception;
    public String supprimerDocument(String id) throws Exception;
    
}
