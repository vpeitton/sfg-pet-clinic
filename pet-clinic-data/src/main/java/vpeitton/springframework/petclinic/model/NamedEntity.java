package vpeitton.springframework.petclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NamedEntity extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public NamedEntity(Long id, String lastName, String firstName) {
        super(id);
        this.lastName = lastName;
        this.firstName=firstName;
    }

    @Override
    public String toString() {
        return this.getFirstName() + this.getLastName();
    }
}
