package vpeitton.springframework.petclinic.repositories;

import vpeitton.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
    Vet findByLastName(String lastName);
}
