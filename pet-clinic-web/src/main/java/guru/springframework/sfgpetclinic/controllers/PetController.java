package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetController {

    @RequestMapping({"/", "pets.html","index.html","index",""})
    public String listPets() {

        return "pets/index";
    }

}
