package org.doranco.projet_java_groupe3.controller;

import org.doranco.projet_java_groupe3.models.Document;
import org.doranco.projet_java_groupe3.service.IDocumentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    private final IDocumentService documentService;

    public DocumentController(IDocumentService documentService) {
        this.documentService = documentService;
    }
    
    @GetMapping
    public String getDocumentsString(
        Model model,
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="page", defaultValue = "0") int page) {

            try {
                Page<Document> documents = documentService.afficherDocuments(PageRequest.of(page,size));
                model.addAttribute("documents", documents);
                model.addAttribute("pages", new int[documents.getTotalPages()]);
                model.addAttribute("current_page", page);
            } catch (Exception e) {
                model.addAttribute("error",e.getMessage());
                throw new RuntimeException(e);
            }
            return "documents";

    }
}
