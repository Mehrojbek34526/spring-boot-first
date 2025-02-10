package uz.pdp.spring_boot_first.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import uz.pdp.spring_boot_first.entity.template.AbsUUIDEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
@SQLDelete(sql = ("update employee set deleted=true where id=?"))
//delete komanda berilganda ushbu yozilgan queryga almashtiradi
public class Employee extends AbsUUIDEntity {

    //Olim
    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private LocalDate birthDate;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    private Attachment photo;

    @ToString.Exclude
    @ManyToMany//Fido biznes, Uzum, Epam, Uzsama, Yandex
    //3-table employee_companies(emp_id, comp_id)
    private List<Company> workingCompanies = new ArrayList<>();

    @ToString.Exclude
    @OneToMany
    private List<BankCard> cards = new ArrayList<>();
}
