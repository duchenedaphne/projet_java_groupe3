package org.doranco.projet_java_groupe3.habitation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.doranco.projet_java_groupe3.photo.IPhotoService;
import org.doranco.projet_java_groupe3.photo.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final IPhotoService photoService;

    private final String UPLOAD_DIR = "./src/main/resources/static/uploads/habitations/";
    
    public HabitationController(IHabitationService habitationService, 
                                IPhotoService photoService) {
        this.habitationService = habitationService;
        this.photoService = photoService;
    }

    @GetMapping
    public String getHabitationsPage(
        Model model,
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="page", defaultValue = "0") int page) {

        try {
            Page<Habitation> habitations = habitationService.afficherHabitations(PageRequest.of(page,size));
            model.addAttribute("habitations", habitations);
            // model.addAttribute("photos", photos);
            model.addAttribute("pages", new int[habitations.getTotalPages()]);
            model.addAttribute("current_page", page);
            model.addAttribute("habitation", new Habitation());
            // model.addAttribute("photo", new Photo());

        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }        
        return "habitations";
    }

    @PostMapping(path = "save", produces = "application/json")
    public String saveHabitation(
        @ModelAttribute("habitation") Habitation habitation,
        // @ModelAttribute("photo") Photo photo,
        @RequestParam("file") MultipartFile file, RedirectAttributes attributes
        ) {
          
        try {
            if (!file.isEmpty()) {
                String fileName = StringUtils.cleanPath(file.getOriginalFilename());    
                try {
                    Path path = Paths.get(UPLOAD_DIR + fileName);
                    Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                    habitation.setPhoto("./uploads/habitations/" + fileName);
                    /* 
                    photo.setPath(path.toString());

                    photoService.ajouterPhoto(photo);

                    List<Photo> photos = new ArrayList<>();

                    photos.add(photo);

                    habitation.setPhotos(photos);
                    */

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }  
            habitationService.ajouterHabitation(habitation);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "redirect:/habitations";
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
    
}
