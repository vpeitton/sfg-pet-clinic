package vpeitton.springframework.petclinic.services;

import vpeitton.springframework.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}