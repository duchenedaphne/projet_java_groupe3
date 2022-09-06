package org.doranco.projet_java_groupe3.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.doranco.projet_java_groupe3.models.Habitation;
import org.doranco.projet_java_groupe3.service.IHabitationService;
import org.doranco.projet_java_groupe3.service.IPhotoService;
import org.doranco.projet_java_groupe3.service.IUserService;
import org.doranco.projet_java_groupe3.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/habitations")
public class HabitationController {
    
    private final IHabitationService habitationService;
    private final IUserService userService;
    private final IPhotoService photoService;

    private final String UPLOAD_DIR = "./src/main/resources/static/uploads/habitations/";
    
    public HabitationController(IHabitationService habitationService, 
                                IPhotoService photoService,
                                IUserService userService) {
        this.habitationService = habitationService;
        this.photoService = photoService;
        this.userService = userService;
    }

    @GetMapping
    public String getHabitationsPage(Model model) {

        try {
            List<Habitation> habitations = habitationService.afficherHabitations();
            model.addAttribute("habitations", habitations);
            model.addAttribute("habitation", new Habitation());
            model.addAttribute("user", new User());

        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }

        return "habitationsD";
    }

    @PostMapping(path = "save", produces = "application/json")
    public String saveHabitation(
        @ModelAttribute("habitation") Habitation habitation,
        BindingResult result,
        Model model
        // @ModelAttribute("photo") Photo photo,
        // @ModelAttribute("user") User user,
        // @RequestParam("file") MultipartFile file, RedirectAttributes attributes
        ) {
          
        try {
//            if (!file.isEmpty()) {
//                String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//                try {
//                    Path path = Paths.get(UPLOAD_DIR + fileName);
//                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//
//                    habitation.setPhoto("./uploads/habitations/" + fileName);
//                    /*
//                    photo.setPath(path.toString());
//                    photoService.ajouterPhoto(photo);
//                    List<Photo> photos = new ArrayList<>();
//                    photos.add(photo);
//                    habitation.setPhotos(photos);
//                    */
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            habitationService.ajouterHabitation(habitation);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "fragments/confirm :: message";
    }

    @RequestMapping(path = "update/{id}")
    public ModelAndView updateHabitation(
        @PathVariable(name = "id") String id
    ) {
        try {
            ModelAndView modelAndView = new ModelAndView("hupdate");

            Habitation habitation = habitationService.detailsHabitation(id);
            modelAndView.addObject("habitation", habitation);

            return modelAndView;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @PostMapping(path = "update/save", produces = "application/json")
    public String updateHabitation(
        @ModelAttribute("habitation") Habitation habitation
    ) {
        try {
            habitationService.ajouterHabitation(habitation);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/habitations";
    }

    @RequestMapping(path = "delete/{id}")
    public String deleteHabitation(
        @PathVariable(name = "id") String id
    ) {
        try {
            habitationService.supprimerHabitation(id);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/habitations";
    }

    @PostMapping(path = "upload")
    public String uploadFile(
        @RequestParam("file") MultipartFile file, RedirectAttributes attributes
        ) {
        
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Ajoutez une photo.");
            return "redirect:/habitations";
        }
        
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        attributes.addFlashAttribute("message", "Photo ajoutée avec succès !");

        return "redirect:/habitations";
    }

/*    @RequestMapping("/fhbu/{username}")
    public String fhbu(@PathVariable(name = "username") String username) {
        try {
            habitationService.filtrerHabitationsParUsername(username);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "f_habitations";
    }*/
    
}
