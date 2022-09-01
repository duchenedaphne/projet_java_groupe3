package org.doranco.projet_java_groupe3.habitation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api/habitations")
public class HabitationRestController {
    
    private final IHabitationService habitationService;

    public HabitationRestController(IHabitationService habitationService) {
        this.habitationService = habitationService;
    }

    @GetMapping
    public Page<Habitation> getHabitationsPage(
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="page", defaultValue = "0") int page) {

        Page<Habitation> habitations = null;
        try {
            habitations = habitationService.afficherHabitations(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return habitations;
    }

    @PostMapping("/poster")
    public Habitation saveHabitation(
        @RequestBody Habitation habitation
        ) {
        Habitation habitation2 = null;
        try {
            habitation2 = habitationService.ajouterHabitation(habitation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return habitation2;
    }
}
