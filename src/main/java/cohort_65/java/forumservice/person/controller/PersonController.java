package cohort_65.java.forumservice.person.controller;

import cohort_65.java.forumservice.person.dto.CityPopulationDto;
import cohort_65.java.forumservice.person.dto.PersonCreateDto;
import cohort_65.java.forumservice.person.dto.PersonDto;
import cohort_65.java.forumservice.person.dto.PersonUpdateDto;
import cohort_65.java.forumservice.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping
    public PersonDto addPerson(@RequestBody PersonCreateDto dto) {
        return service.addPerson(dto);
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable Long id) {
        return service.getPerson(id);
    }

    @GetMapping("/name/{name}")
    public List<PersonDto> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/city/{city}")
    public List<PersonDto> findByCity(@PathVariable String city) {
        return service.findByCity(city);
    }

    @GetMapping("/ages/{from}/{to}")
    public List<PersonDto> findByAges(@PathVariable int from, @PathVariable int to) {
        return service.findByAges(from, to);
    }

    @PutMapping("/{id}/name/{newName}")
    public PersonDto updateName(@PathVariable Long id, @PathVariable String newName) {
        return service.updateName(id, newName);
    }

    @PutMapping("/{id}/address")
    public PersonDto updateAddress(@PathVariable Long id, @RequestBody PersonUpdateDto dto) {
        return service.updateAddress(id, dto);
    }

    @GetMapping("/population/city")
    public List<CityPopulationDto> getCityPopulation() {
        return service.getCityPopulation();
    }

    @DeleteMapping("/{id}")
    public PersonDto deletePerson(@PathVariable Long id) {
        return service.deletePerson(id);
    }
}
