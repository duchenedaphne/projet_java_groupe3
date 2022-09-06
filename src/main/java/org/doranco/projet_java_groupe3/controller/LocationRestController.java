package org.doranco.projet_java_groupe3.controller;

import org.doranco.projet_java_groupe3.service.ILocationService;
import org.doranco.projet_java_groupe3.models.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/locations")
public class LocationRestController {
    
    private final ILocationService locationService;

    public LocationRestController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public Page<Location> getLocationsPage(
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="page", defaultValue = "0") int page
    ) {
        Page<Location> locations = null;
        try {
            locations = locationService.afficherLocations(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return locations;
    }

    @PostMapping("/ajout")
    public Location saveLocation(@RequestBody Location location) {
        Location location2 = null;
        try {
            location2 = locationService.createLocation(location);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return location2;
    }
}
