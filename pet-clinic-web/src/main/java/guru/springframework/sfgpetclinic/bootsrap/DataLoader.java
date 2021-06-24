package guru.springframework.sfgpetclinic.bootsrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Rouillon 1050");
        owner1.setCity("Rosario");
        owner1.setTelephone("0303456");
        ownerService.save(owner1);

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setName("Maite");
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);
        petService.save(mikesPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Victoria");
        owner2.setLastName("Peitton");
        owner2.setAddress("Campbell 844");
        owner2.setCity("Rosario");
        owner2.setTelephone("156272224");
        ownerService.save(owner2);

        Pet vicsPet = new Pet();
        vicsPet.setPetType(saveCatPetType);
        vicsPet.setOwner(owner2);
        vicsPet.setName("Dany");
        vicsPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(vicsPet);
        petService.save(vicsPet);

        System.out.println("\nLoaded Owners....");
        System.out.println("\nLoaded Pets....");


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Fiona");
        vet2.setLastName("Glenanne");
        vetService.save(vet2);

        System.out.println("\nLoaded Vets....");

    }
}
