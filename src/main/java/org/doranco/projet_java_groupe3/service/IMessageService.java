package org.doranco.projet_java_groupe3.service;

import org.doranco.projet_java_groupe3.models.Message;

public interface IMessageService {
    
    public Message creerMessage() throws Exception;
    public Message afficherMessage() throws Exception;
    public Message supprimerMessage() throws Exception;

}
