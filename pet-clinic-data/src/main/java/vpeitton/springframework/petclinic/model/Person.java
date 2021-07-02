package vpeitton.springframework.petclinic.model;

import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
public class Person extends NamedEntity{

    public Person(Long id, String firstName, String lastName) {
        super(id,lastName,firstName);
    }
}
