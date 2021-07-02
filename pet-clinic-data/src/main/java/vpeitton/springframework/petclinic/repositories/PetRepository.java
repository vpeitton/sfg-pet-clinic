package vpeitton.springframework.petclinic.repositories;

import vpeitton.springframework.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
