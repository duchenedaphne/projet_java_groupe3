package org.doranco.projet_java_groupe3.habitation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
@RequestMapping("/habitations")
public class HabitationController {
    
    private final IHabitationService habitationService;

    public HabitationController(IHabitationService habitationService) {
        this.habitationService = habitationService;
    }

    @GetMapping
    public String getHabitationsPage(
        Model model,
        @RequestParam(name="size", defaultValue = "5") int size,
        @RequestParam(name="page", defaultValue = "0") int page) {

        try {
            Page<Habitation> habitations = habitationService.afficherHabitations(PageRequest.of(page,size));
            model.addAttribute("habitations", habitations);
            model.addAttribute("pages", new int[habitations.getTotalPages()]);
            model.addAttribute("current_page", page);
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            throw new RuntimeException(e);
        }        

        return "habitations";
        
    }
}
