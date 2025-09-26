package cohort_65.java.forumservice.person.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonCreateDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private AddressDto address;
}
