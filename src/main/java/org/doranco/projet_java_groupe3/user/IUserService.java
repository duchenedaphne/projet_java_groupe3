package org.doranco.projet_java_groupe3.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

// import java.util.List;

public interface IUserService {

   public User saveUser(User user) throws Exception;

   public User updateUser(User user) throws Exception;

   public User detailsUser(String id) throws Exception;

   public String supprimerUser(String id) throws Exception;

   public Page<User> getAllUsers(Pageable pageable) throws Exception;


   // public Page<User> afficherUser(PageRequest of) throws Exception;

}
