package org.doranco.projet_java_groupe3.controller;

import org.doranco.projet_java_groupe3.models.Habitation;
import org.doranco.projet_java_groupe3.service.IHabitationService;
import org.doranco.projet_java_groupe3.service.IUserService;
import org.doranco.projet_java_groupe3.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;
    private final IHabitationService habitationService;

    private final String UPLOAD_DIR = "./src/main/resources/static/uploads/habitations/";

    public UserController(IUserService userService,
                            IHabitationService habitationService) {
        this.userService = userService;
        this.habitationService = habitationService;
    }

    @GetMapping
    public String getUsersPage( Model model) {

        try {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("user", new User());

        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }
        return "fragments/confirm :: confirm";
    }

    @GetMapping("/backoffice")
    public String getUsersBO( Model model) {

        try {
            List<User> users = userService.getAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("user", new User());

        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }
        return "layout/user_backoffice";
    }

    @PostMapping(path= "save", produces = "application/json")
    public String saveUser(
            @ModelAttribute("user") User user,
            BindingResult result,
            Model model
    ) {
        try {
            userService.saveUser(user);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "fragments/confirm :: message";
    }

    @PostMapping(path= "saveBO", produces = "application/json")
    public String saveUserBO(
            @ModelAttribute("user") User user,
            BindingResult result,
            Model model
    ) {
        try {
            userService.saveUser(user);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/users/backoffice";
    }

    @RequestMapping(path="update/{username}")
    public String updateUserGoToPage(
            @PathVariable(name = "username") String username,
            Model model
    ) {
        try {
            User user = userService.detailsUser(username);
            model.addAttribute("user", user);
            model.addAttribute("habitation", new Habitation());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "layout/u_update";
    }

    @PostMapping(path= "update/save",produces = "application/json")
    public String updateUser(
            @ModelAttribute("user") User user
    ) {
        try {
            userService.saveUser(user);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/users/backoffice";
    }
    
    @PostMapping(path = "update/habitation", produces = "application/json")
    public String saveHabitation(

        @ModelAttribute("habitation") Habitation habitation,
        @ModelAttribute("user") User user,
        @RequestParam("file") MultipartFile file, RedirectAttributes attributes
        ) {
        try { 
            if (user != null) {
                habitation.setUser(user); 
            }
            if (!file.isEmpty()) {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());    
                try {
                    Path path = Paths.get(UPLOAD_DIR + fileName);
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                    habitation.setPhoto("./uploads/habitations/" + fileName);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (habitation != null) {
                user.getHabitations().add(habitation);
            }  
            
            habitationService.ajouterHabitation(habitation);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/users/backoffice";
    }

    @RequestMapping(path = "delete/{username}")
    public String deleteUser(
            @PathVariable(name = "username") String username
    ) {
        try {
            userService.supprimerUser(username);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/users/backoffice";
    }

}

