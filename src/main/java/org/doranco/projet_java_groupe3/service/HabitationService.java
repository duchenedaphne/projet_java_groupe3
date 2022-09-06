package org.doranco.projet_java_groupe3.service;

import java.util.List;
import java.util.Optional;

import org.doranco.projet_java_groupe3.dao.HabitationRepository;
import org.doranco.projet_java_groupe3.models.Habitation;
import org.doranco.projet_java_groupe3.models.User;
import org.doranco.projet_java_groupe3.dao.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HabitationService implements IHabitationService {

    private final HabitationRepository habitationRepository;
    private final UserRepository userRepository;

    public HabitationService(HabitationRepository habitationRepository, UserRepository userRepository) {
        this.habitationRepository = habitationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Habitation ajouterHabitation(Habitation habitation) throws Exception {
        
        return habitationRepository.save(habitation);
    }

    @Override
    public Habitation modifierHabitation(Habitation habitation) throws Exception {
        
        return habitationRepository.save(habitation);
    }

    @Override
    public List<Habitation> afficherHabitations() throws Exception {
        
        return habitationRepository.findAll();
    }

    @Override
    public Habitation detailsHabitation(String id) throws Exception {

        Optional<Habitation> habitationOptional = habitationRepository.findById(id);
        if (habitationOptional.isPresent()) {
            return habitationOptional.get();
        } else {
            throw new RuntimeException("Aucune habitation trouvée.");
        }
    }

    @Override
    public String supprimerHabitation(String id) throws Exception {

        habitationRepository.deleteById(id);
        return "L'habitation a bien été supprimée";
    }

    @Override
    public List<Habitation> filtrerHabitationsParPrix(double prix) throws Exception {

        if(prix < 0) throw new Exception("Le prix doit être > 0");
        
        return habitationRepository.findHabitationByPrixLessThan(prix);
    }

    @Override
    public List<Habitation> filtrerHabitationsParDepartement(int departement) throws Exception {

        if(departement < 0) throw new Exception("Le département ne peut pas être égale à 0");
        
        return habitationRepository.findHabitationByPrixLessThan(departement);
    }

    @Override
    public Habitation selectionnerHabitation(String id) throws Exception {
        
        Optional<Habitation> habitationOptional = habitationRepository.findById(id);
        if (habitationOptional.isPresent()) {
            return habitationOptional.get();
        } else {
            throw new RuntimeException("Aucune habitation trouvée");
        }
    }

    @Override
    public Habitation addUser(User user) throws Exception {

        Habitation habitation = new Habitation();
        habitation.setUser(user);
        
        return habitation;
    }

/*    @Override
    public Habitation filtrerHabitationsParUsername(String username) throws Exception {
        User user = userRepository.findUserByUsername(username);
        return habitationRepository.findHabitationByUsername(username);
    }*/

}
