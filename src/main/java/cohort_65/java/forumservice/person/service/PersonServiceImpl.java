package cohort_65.java.forumservice.person.service;

import cohort_65.java.forumservice.person.dao.PersonRepository;
import cohort_65.java.forumservice.person.dto.CityPopulationDto;
import cohort_65.java.forumservice.person.dto.PersonCreateDto;
import cohort_65.java.forumservice.person.dto.PersonDto;
import cohort_65.java.forumservice.person.dto.PersonUpdateDto;
import cohort_65.java.forumservice.person.exception.PersonExistsException;
import cohort_65.java.forumservice.person.exception.PersonNotFoundException;
import cohort_65.java.forumservice.person.model.Person;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public PersonDto addPerson(PersonCreateDto dto) {

        if (repository.existsById(dto.getId())) {
            throw new PersonExistsException("Person with id " + dto.getId() + " already exists");
        }

        Person person = modelMapper.map(dto, Person.class);
        person = repository.save(person);
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public PersonDto getPerson(Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id));
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public List<PersonDto> findByName(String name) {
        List<Person> persons = repository.findByNameIgnoreCase(name);
        if (persons.isEmpty()) {
            throw new PersonNotFoundException("No persons found with name: " + name);
        }
        return persons.stream()
                .map(p -> modelMapper.map(p, PersonDto.class))
                .toList();
    }

    @Override
    public List<PersonDto> findByCity(String city) {
        List<Person> persons = repository.findByAddress_CityIgnoreCase(city);
        if (persons.isEmpty()) {
            throw new PersonNotFoundException("No persons found in city: " + city);
        }
        return persons.stream()
                .map(p -> modelMapper.map(p, PersonDto.class))
                .toList();
    }

    @Override
    public List<PersonDto> findByAges(int from, int to) {
        LocalDate now = LocalDate.now();
        LocalDate dateFrom = now.minusYears(to);
        LocalDate dateTo = now.minusYears(from);

        List<Person> persons = repository.findByBirthDateBetween(dateFrom, dateTo);
        if (persons.isEmpty()) {
            throw new PersonNotFoundException("No persons found between ages: " + from + " - " + to);
        }
        return persons.stream()
                .map(p -> modelMapper.map(p, PersonDto.class))
                .toList();
    }

    @Override
    public PersonDto updateName(Long id, String newName) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id));
        person.setName(newName);
        person = repository.save(person);
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public PersonDto updateAddress(Long id, PersonUpdateDto dto) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id));

        if (dto.getCity() != null) person.getAddress().setCity(dto.getCity());
        if (dto.getStreet() != null) person.getAddress().setStreet(dto.getStreet());
        if (dto.getBuilding() != 0) person.getAddress().setBuilding(dto.getBuilding());

        person = repository.save(person);
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public List<CityPopulationDto> getCityPopulation() {
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(
                        p -> p.getAddress().getCity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .map(e -> new CityPopulationDto(e.getKey(), e.getValue()))
                .toList();
    }

    @Override
    public PersonDto deletePerson(Long id) {
        Person person = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Person not found with id: " + id));
        repository.delete(person);
        return modelMapper.map(person, PersonDto.class);
    }
}
