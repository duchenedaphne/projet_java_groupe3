package org.doranco.projet_java_groupe3.message;

public interface IMessageService {
    
    public Message creerMessage() throws Exception;
    public Message afficherMessage() throws Exception;
    public Message supprimerMessage() throws Exception;

}
