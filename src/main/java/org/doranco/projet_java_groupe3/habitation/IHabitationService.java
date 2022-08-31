package org.doranco.projet_java_groupe3.habitation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHabitationService {

    public Habitation ajouterHabitation(Habitation habitation) throws Exception;
    public Habitation modifierHabitation(Habitation habitation) throws Exception;

    public Page<Habitation> afficherHabitations(Pageable pageable) throws Exception;
    public Habitation detailsHabitation(String ref) throws Exception;

    public String supprimerHabitation(String ref) throws Exception;

    public Page<Habitation> filtrerHabitationsParPrix(double prix, Pageable pageable) throws Exception;

    public Page<Habitation> filtrerHabitationsParDepartement(int departement, Pageable pageable) throws Exception;

    public Habitation selectionnerHabitation(String ref) throws Exception;
    
}
