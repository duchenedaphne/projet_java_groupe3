package org.doranco.projet_java_groupe3.user;

import org.doranco.projet_java_groupe3.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findAuthoritiesByUsersContains(User user);
    List<Authority> findAuthoritiesByUsers(List<User> users);
}
