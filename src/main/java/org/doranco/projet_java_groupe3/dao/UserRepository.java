package org.doranco.projet_java_groupe3.dao;

import org.doranco.projet_java_groupe3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.RequestMapping;

// @RepositoryRestResource
// @RequestMapping
public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUsername(String username);


}
