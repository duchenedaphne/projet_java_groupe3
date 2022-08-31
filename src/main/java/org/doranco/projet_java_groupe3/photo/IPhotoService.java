package org.doranco.projet_java_groupe3.photo;

public interface IPhotoService {
    
    public Photo ajouterPhoto() throws Exception;
    public Photo afficherPhoto() throws Exception;
    public Photo modifierPhoto() throws Exception;
    public Photo supprimerPhoto() throws Exception;

}
