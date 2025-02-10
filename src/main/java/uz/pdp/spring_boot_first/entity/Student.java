package uz.pdp.spring_boot_first.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.spring_boot_first.entity.template.AbsLongEntity;
import uz.pdp.spring_boot_first.enums.GenderEnum;

import java.time.LocalDate;

/**
 Created by: Mehrojbek
 DateTime: 07/02/25 21:45
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Student", indexes = {
        @Index(name = "idx_student_email_birthdate", columnList = "email, birthDate")
})
@NamedQueries({
        @NamedQuery(name = "Student.findByFirstNameContainsIgnoreCaseOrderByCreatedAtDesc", query = "select s from Student s where upper(s.firstName) like upper(concat('%', :firstName, '%')) order by s.createdAt DESC", lockMode = LockModeType.OPTIMISTIC)
})
public class Student extends AbsLongEntity {

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    private String email;

    @Transient
    private String test;

}
