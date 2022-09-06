package org.doranco.projet_java_groupe3.controller;

import org.doranco.projet_java_groupe3.service.IPhotoService;
import org.doranco.projet_java_groupe3.models.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/habitations/photos")
public class PhotoRestController {

    private final IPhotoService photoService;

    public PhotoRestController(IPhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public Page<Photo> getPhotosPage(
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="page", defaultValue = "0") int page
    ) {
        Page<Photo> photos = null;
        try {
            photos = photoService.afficherPhotos(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return photos;
    }

    @PostMapping("/poster")
    public Photo savePhoto(@RequestBody Photo photo) {
        Photo photo2 = null;
        try {
            photo2 = photoService.ajouterPhoto(photo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return photo2;
    }
    
}
