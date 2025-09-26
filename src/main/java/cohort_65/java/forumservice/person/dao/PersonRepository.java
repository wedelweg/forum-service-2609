package cohort_65.java.forumservice.person.dao;

import cohort_65.java.forumservice.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsById(Long id);

    List<Person> findByNameIgnoreCase(String name);

    List<Person> findByAddress_CityIgnoreCase(String city);

    List<Person> findByBirthDateBetween(LocalDate from, LocalDate to);
}
