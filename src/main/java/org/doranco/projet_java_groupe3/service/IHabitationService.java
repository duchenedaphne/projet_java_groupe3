package org.doranco.projet_java_groupe3.service;

import org.doranco.projet_java_groupe3.models.Habitation;
import org.doranco.projet_java_groupe3.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHabitationService {

    public Habitation ajouterHabitation(Habitation habitation) throws Exception;

    public Habitation modifierHabitation(Habitation habitation) throws Exception;

    public List<Habitation> afficherHabitations() throws Exception;

    public Habitation detailsHabitation(String id) throws Exception;

    public String supprimerHabitation(String id) throws Exception;

    public List<Habitation> filtrerHabitationsParPrix(double prix) throws Exception;

    public List<Habitation> filtrerHabitationsParDepartement(int departement) throws Exception;

    public Habitation selectionnerHabitation(String id) throws Exception;

    public Habitation addUser(User user) throws Exception;

    // public Habitation filtrerHabitationsParUsername(String username) throws Exception;
    
}
