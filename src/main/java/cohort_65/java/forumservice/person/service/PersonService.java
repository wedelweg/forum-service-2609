package cohort_65.java.forumservice.person.service;

import cohort_65.java.forumservice.person.dto.*;

import java.util.List;

public interface PersonService {

    PersonDto addPerson(PersonCreateDto dto);

    PersonDto getPerson(Long id);

    List<PersonDto> findByName(String name);

    List<PersonDto> findByCity(String city);

    List<PersonDto> findByAges(int from, int to);

    PersonDto updateName(Long id, String newName);

    PersonDto updateAddress(Long id, PersonUpdateDto dto);

    List<CityPopulationDto> getCityPopulation();

    PersonDto deletePerson(Long id);

    Iterable<EmployeeDto> findEmployeeBySalary(Integer min, Integer max);
    Iterable<ChildDto> findAllChildren();
}
