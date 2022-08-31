package org.doranco.projet_java_groupe3.location;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocationService implements ILocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location createLocation(Location location) throws Exception {
        
        return locationRepository.save(location);
    }

    @Override
    public Page<Location> afficherLocations(Pageable pageable) throws Exception {
        
        return locationRepository.findAll(pageable);
    }

    @Override
    public Location detailsLocation(String id) throws Exception {
        
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (locationOptional.isPresent()) {
            return locationOptional.get();
        } else {
            throw new RuntimeException("Location non trouvée.");
        }
    }

    
    
}
