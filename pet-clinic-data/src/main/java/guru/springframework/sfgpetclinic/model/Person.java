package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@NoArgsConstructor
public class Person extends NamedEntity{

    public Person(Long id, String firstName, String lastName) {
        super(id,lastName,firstName);
    }
}
