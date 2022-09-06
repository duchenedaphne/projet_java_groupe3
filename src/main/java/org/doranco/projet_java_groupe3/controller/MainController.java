package org.doranco.projet_java_groupe3.controller;

import org.doranco.projet_java_groupe3.models.Habitation;
import org.doranco.projet_java_groupe3.service.IHabitationService;
import org.doranco.projet_java_groupe3.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.doranco.projet_java_groupe3.models.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/index")
public class MainController {

    private final IUserService userService;
    private final IHabitationService habitationService;

    public MainController(IUserService userService, IHabitationService habitationService) {
        this.userService = userService;
        this.habitationService = habitationService;
    }

    @GetMapping()
    public String IndexController(Model model){
        try {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("user", new User());

        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }

        try {
            List<Habitation> habitations = habitationService.afficherHabitations();
            model.addAttribute("habitations", habitations);
            model.addAttribute("habitation", new Habitation());
            model.addAttribute("user", new User());

        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }

        return "layout/index";
    }
}
