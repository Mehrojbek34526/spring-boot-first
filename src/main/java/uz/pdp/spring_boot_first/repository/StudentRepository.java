package uz.pdp.spring_boot_first.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_boot_first.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}