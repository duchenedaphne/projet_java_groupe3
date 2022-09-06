package org.doranco.projet_java_groupe3.controller;

import org.doranco.projet_java_groupe3.service.IPhotoService;
import org.doranco.projet_java_groupe3.models.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/habitations/photos")
public class PhotoController {
    
    private final IPhotoService photoService;

    public PhotoController(IPhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public String getPhotosString(
        Model model,
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="page", defaultValue = "0") int page) {

            try {
                Page<Photo> photos = photoService.afficherPhotos(PageRequest.of(page,size));
                model.addAttribute("photos", photos);
                model.addAttribute("pages", new int[photos.getTotalPages()]);
                model.addAttribute("current_page", page);
            } catch (Exception e) {
                model.addAttribute("error",e.getMessage());
                throw new RuntimeException(e);
            }
            return "photos";

    }

}
