package cohort_65.java.personservice.person.service;

import cohort_65.java.personservice.person.dto.NewPersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {


    @Override
    public boolean addPerson(NewPersonDto newPersonDto) {
        return false;
    }
}
