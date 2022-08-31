package org.doranco.projet_java_groupe3.document;

public interface IDocumentService {
    
    public Document transmettreDocument() throws Exception;
    public Document afficherDocument() throws Exception;
    public Document modifierDocument() throws Exception;
    public Document supprimerDocument() throws Exception;
    
}
