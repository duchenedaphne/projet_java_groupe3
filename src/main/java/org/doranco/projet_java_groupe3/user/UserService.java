package org.doranco.projet_java_groupe3.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User detailsUser(String id) {

        return userRepository.findUserById(id);
    }

    @Override
    public String supprimerUser(String id) {
        
        userRepository.deleteById(id);
        return "L'utilisateur a bien été supprimé ";
    }

/*
    @Override
    public List<User> afficherUser(PageRequest of) {
        return userRepository.findAll();
    }
*/

}
