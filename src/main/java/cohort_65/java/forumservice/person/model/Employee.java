package cohort_65.java.forumservice.person.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee extends Person {

    private String company;
    private int salary;

    public Employee(Long id, String name, LocalDate birthDate, Address address, String company, int salary) {
        super(id, name, birthDate, address);
        this.company = company;
        this.salary = salary;
    }
}
