package org.doranco.projet_java_groupe3.controller;

import org.doranco.projet_java_groupe3.models.Document;
import org.doranco.projet_java_groupe3.service.IDocumentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/documents")
public class DocumentRestController {

    private final IDocumentService documentService;

    public DocumentRestController(IDocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public Page<Document> getDocumentsPage(
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="page", defaultValue = "0") int page
    ) {
        Page<Document> documents = null;
        try {
            documents = documentService.afficherDocuments(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return documents;
    }

    @PostMapping("/transmettre")
    public Document saveDocument(@RequestBody Document document) {
        Document document2 = null;
        try {
            document2 = documentService.transmettreDocument(document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return document2;
    }
    
}
