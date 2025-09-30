package cohort_65.java.personservice.person.contoller;

import cohort_65.java.personservice.person.dto.NewPersonDto;
import cohort_65.java.personservice.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    final PersonService personService;

    @PostMapping
    public boolean addPerson(@RequestBody NewPersonDto newPersonDto) {
        return personService.addPerson(newPersonDto);
    }


}
