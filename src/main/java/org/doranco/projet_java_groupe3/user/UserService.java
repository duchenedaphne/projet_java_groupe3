package org.doranco.projet_java_groupe3.user;

import org.doranco.projet_java_groupe3.habitation.Habitation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) throws Exception {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) throws Exception {
        
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) throws Exception {
        
        return userRepository.findAll(pageable);
    }

    @Override
    public User detailsUser(String username) {

        return userRepository.findUserByUsername(username);
    }

    @Override
    public String supprimerUser(String username) {
        
        userRepository.deleteById(username);
        return "L'utilisateur a bien été supprimé ";
    }

    @Override
    public User addHabitation(Habitation habitation) throws Exception {
        
        User user = new User();
        user.getHabitations().add(habitation);
        
        return user;
    }

/*
    @Override
    public List<User> afficherUser(PageRequest of) {
        return userRepository.findAll();
    }
*/

}
