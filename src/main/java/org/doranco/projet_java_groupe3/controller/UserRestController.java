package org.doranco.projet_java_groupe3.controller;

import org.doranco.projet_java_groupe3.service.IUserService;
import org.doranco.projet_java_groupe3.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final IUserService userService;

    public UserRestController(IUserService userService) {
        this.userService =userService;
    }

    @GetMapping
    public List<User> getAllUsers(){

        List<User> users;
        try {
            users = userService.getAllUsers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @PostMapping("/poster")
    public User saveUser(
        @RequestBody User user
    ) {
        User user2 = null;
        try {
            user = userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user2;
    }
}