package org.doranco.projet_java_groupe3.controller;

import org.doranco.projet_java_groupe3.service.ILocationService;
import org.doranco.projet_java_groupe3.models.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/locations")
public class LocationController {
    
    private final ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public String getLocationsString(
        Model model,
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="page", defaultValue = "0") int page
    ) {
        try {
            Page<Location> locations = locationService.afficherLocations(PageRequest.of(page,size));
            model.addAttribute("locations", locations);
            model.addAttribute("pages", new int[locations.getTotalPages()]);
            model.addAttribute("current_page", page);
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }
        return "locations";
    }

}
