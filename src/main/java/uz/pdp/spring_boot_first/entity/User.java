package uz.pdp.spring_boot_first.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import uz.pdp.spring_boot_first.entity.template.AbsUUIDEntity;
import uz.pdp.spring_boot_first.enums.GenderEnum;
import uz.pdp.spring_boot_first.enums.RoleEnum;

import java.time.LocalDate;

/**
 Created by: Mehrojbek
 DateTime: 03/02/25 19:33
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "users")
@SQLRestriction(value = "deleted=false")
@SQLDelete(sql = "update users set deleted=true where id=?")
@FieldNameConstants
public class User extends AbsUUIDEntity {

    private String firstName;

    private String lastName;

    //john12 -> deleted=true
    //john12 ->
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

}
