package vpeitton.springframework.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vet_specialities")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

}
