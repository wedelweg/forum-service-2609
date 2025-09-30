package cohort_65.java.personservice.person.dao;

import cohort_65.java.personservice.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
