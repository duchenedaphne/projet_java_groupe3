package org.doranco.projet_java_groupe3.service;

import java.util.Optional;

import org.doranco.projet_java_groupe3.dao.PhotoRepository;
import org.doranco.projet_java_groupe3.models.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PhotoService implements IPhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo ajouterPhoto(Photo photo) throws Exception {
        
        return photoRepository.save(photo);
    }

    @Override
    public Page<Photo> afficherPhotos(Pageable pageable) throws Exception {
        
        return photoRepository.findAll(pageable);
    }

    @Override
    public Photo voirPhoto(String id) throws Exception {
        
        Optional<Photo> photoOptional = photoRepository.findById(id);
        if (photoOptional.isPresent()) {
            return photoOptional.get();
        } else {
            throw new RuntimeException("Photo non trouvée.");
        }
    }

    @Override
    public String supprimerPhoto(String id) throws Exception {
        
        photoRepository.deleteById(id);
        return "La photo a bien été supprimée.";
    }
    
}
