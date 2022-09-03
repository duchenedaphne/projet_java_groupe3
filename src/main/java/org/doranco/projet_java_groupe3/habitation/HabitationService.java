package org.doranco.projet_java_groupe3.habitation;

import java.util.Optional;

import org.doranco.projet_java_groupe3.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HabitationService implements IHabitationService {

    private final HabitationRepository habitationRepository;

    public HabitationService(HabitationRepository habitationRepository) {
        this.habitationRepository = habitationRepository;
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
    public Page<Habitation> afficherHabitations(Pageable pageable) throws Exception {
        
        return habitationRepository.findAll(pageable);
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
    public Page<Habitation> filtrerHabitationsParPrix(double prix, Pageable pageable) throws Exception {

        if(prix < 0) throw new Exception("Le prix doit être > 0");
        
        return habitationRepository.findHabitationByPrixLessThan(prix, pageable);
    }

    @Override
    public Page<Habitation> filtrerHabitationsParDepartement(int departement, Pageable pageable) throws Exception {

        if(departement < 0) throw new Exception("Le département ne peut pas être égale à 0");
        
        return habitationRepository.findHabitationByPrixLessThan(departement, pageable);
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

}
