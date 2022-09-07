/*
package org.doranco.projet_java_groupe3.service;

import org.doranco.projet_java_groupe3.dao.UserRepository;
import org.doranco.projet_java_groupe3.models.User;
import org.doranco.projet_java_groupe3.user.AuthorityRepository;
import org.doranco.projet_java_groupe3.utils.EncrytedPasswordUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    private final EncrytedPasswordUtils encrytedPasswordUtils;

    public UserDetailsServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository, EncrytedPasswordUtils encrytedPasswordUtils) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.encrytedPasswordUtils = encrytedPasswordUtils;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found User: " + user);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<String> roleNames = authorityRepository.findAuthoritiesByUsersContains(user).toString();

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(user.getUsername(), user.getPassword(), grantList);

        return userDetails;
    }

}
*/