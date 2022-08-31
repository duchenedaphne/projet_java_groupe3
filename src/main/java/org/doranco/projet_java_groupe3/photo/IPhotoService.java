package org.doranco.projet_java_groupe3.photo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPhotoService {
    
    public Photo ajouterPhoto(Photo photo) throws Exception;

    public Page<Photo> afficherPhotos(Pageable pageable) throws Exception;
    
    public Photo voirPhoto(String id) throws Exception;
    public String supprimerPhoto(String id) throws Exception;

}
