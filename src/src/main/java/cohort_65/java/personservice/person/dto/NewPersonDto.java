package cohort_65.java.personservice.person.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class NewPersonDto {
    Integer id;
    String name;
    LocalDate birthDate;
    AddressDto address;
}
