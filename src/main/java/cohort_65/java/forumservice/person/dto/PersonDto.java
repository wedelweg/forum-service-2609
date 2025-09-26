package cohort_65.java.forumservice.person.dto;

import cohort_65.java.forumservice.person.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private Address address;
}
