package vpeitton.springframework.petclinic.bootsrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vpeitton.springframework.petclinic.model.*;
import vpeitton.springframework.petclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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
        mikesPet.setFirstName("Maite");
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
        vicsPet.setFirstName("Dany");
        vicsPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(vicsPet);
        petService.save(vicsPet);

        Visit catVisit = new Visit();
        catVisit.setPet(vicsPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");


        System.out.println("\nLoaded Owners....");
        System.out.println("\nLoaded Pets....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        System.out.println("\nLoaded Specialties....");


        Vet vet2 = new Vet();
        vet2.setFirstName("Fiona");
        vet2.setLastName("Glenanne");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("\nLoaded Vets....");
    }
}
