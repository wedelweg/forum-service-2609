package cohort_65.java.forumservice.person.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Child extends Person {

    @Column
    private String kindergarten;

    public Child(Long id, String name, LocalDate birthDate, Address address, String kindergarten) {
        super(id, name, birthDate, address);
        this.kindergarten = kindergarten;
    }
}
