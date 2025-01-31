package uz.pdp.spring_boot_first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot_first.entity.Employee;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Optional<Employee> findByPhone(String phone);

    List<Employee> findAllByFirstName(String firstName);

    List<Employee> findAllByFirstNameNotIn(List<String> firstName);

    List<Employee> findAllByFirstNameIn(List<String> firstNames);

    List<Employee> findAllByLastName(String lastName);

    List<Employee> findAllByEmail(String email);

    List<Employee> findAllByPhone(String phone);

    List<Employee> findAllByBirthDateGreaterThan(LocalDate birthDate);

    List<Employee> findAllByBirthDateBetween(LocalDate from, LocalDate to);

    boolean existsByPhone(String phone);

    @Query(value = "select e from Employee e where e.birthDate=:birthDate")
    List<Employee> getMyEmployees(LocalDate birthDate);
}
