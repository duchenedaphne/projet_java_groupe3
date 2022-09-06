package org.doranco.projet_java_groupe3.service;

import org.doranco.projet_java_groupe3.models.Habitation;
import org.doranco.projet_java_groupe3.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// import java.util.List;

public interface IUserService {

   public User saveUser(User user) throws Exception;

   public User updateUser(User user) throws Exception;

   public User detailsUser(String username) throws Exception;

   public String supprimerUser(String username) throws Exception;

   public List<User> getAllUsers() throws Exception;

   public User addHabitation(Habitation habitation, String username) throws Exception;

}
