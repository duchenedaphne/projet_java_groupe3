package org.doranco.projet_java_groupe3.user;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// import org.springframework.web.bind.annotation.RequestMapping;

// @RepositoryRestResource
// @RequestMapping
public interface UserRepository extends JpaRepository<User, String> {

    User findUserById(String id);


}
