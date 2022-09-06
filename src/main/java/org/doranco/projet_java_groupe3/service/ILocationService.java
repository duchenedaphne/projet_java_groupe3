package org.doranco.projet_java_groupe3.service;

import org.doranco.projet_java_groupe3.models.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILocationService {
    
    public Location createLocation(Location location) throws Exception;

    public Page<Location> afficherLocations(Pageable pageable) throws Exception;

    public Location detailsLocation(String id) throws Exception;
    
}
