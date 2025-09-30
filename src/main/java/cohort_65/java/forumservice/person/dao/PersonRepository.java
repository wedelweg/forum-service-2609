package cohort_65.java.forumservice.person.dao;

import cohort_65.java.forumservice.person.model.Child;
import cohort_65.java.forumservice.person.model.Employee;
import cohort_65.java.forumservice.person.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByNameIgnoreCase(String name);

    List<Person> findByAddress_CityIgnoreCase(String city);

    List<Person> findByBirthDateBetween(LocalDate from, LocalDate to);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :min AND :max")
    List<Employee> findEmployeesBySalaryBetween(Integer min, Integer max);

    @Query("SELECT c FROM Child c")
    List<Child> findAllChildren();
}
