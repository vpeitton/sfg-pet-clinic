package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @RequestMapping({"/", "pets.html","index.html","index",""})
    public String listPets(Model model) {

        model.addAttribute("pets", petService.findAll());

        return "pets/index";
    }

}
