package uz.pdp.spring_boot_first.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import uz.pdp.spring_boot_first.entity.template.AbsUUIDEntity;

import java.time.LocalDate;

/**
 Created by: Mehrojbek
 DateTime: 29/01/25 19:58
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(
//        name = "employee"
)
@SQLRestriction(value = "deleted=false")//bazadan ma'lumot olayotganda where ga qo'shimcha shart qo'shadi
@SQLDelete(sql = ("update employee set deleted=true where id=?"))//delete komanda berilganda ushbu yozilgan queryga almashtiradi
public class Employee extends AbsUUIDEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private LocalDate birthDate;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment photo;
}
