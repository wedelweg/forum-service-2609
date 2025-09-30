package cohort_65.java.personservice.person.service;

import cohort_65.java.personservice.person.dto.NewPersonDto;
import org.springframework.stereotype.Service;

public interface PersonService {
    boolean addPerson(NewPersonDto newPersonDto);
}

