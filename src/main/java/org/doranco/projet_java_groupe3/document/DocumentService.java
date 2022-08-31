package org.doranco.projet_java_groupe3.document;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocumentService implements IDocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document transmettreDocument(Document document) throws Exception {
        
        return documentRepository.save(document);
    }

    @Override
    public Document modifierDocument(Document document) throws Exception {
        
        return documentRepository.save(document);
    }

    @Override
    public Page<Document> afficherDocuments(Pageable pageable) throws Exception {
        
        return documentRepository.findAll(pageable);
    }

    @Override
    public Document detailsDocument(String id) throws Exception {
        
        Optional<Document> documentOptional = documentRepository.findById(id);
        if (documentOptional.isPresent()) {
            return documentOptional.get();
        } else {
            throw new RuntimeException("Document non trouvé.");
        }
    }

    @Override
    public String supprimerDocument(String id) throws Exception {
        
        documentRepository.deleteById(id);
        return "Le document a bien été supprimé.";
    }
    
}
