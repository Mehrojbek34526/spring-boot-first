package uz.pdp.spring_boot_first.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import uz.pdp.spring_boot_first.entity.template.AbsLongEntity;

import java.time.LocalDate;

/**
 Created by: Mehrojbek
 DateTime: 07/02/25 19:10
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SQLRestriction(value = "deleted=false")//bazadan ma'lumot olayotganda where ga qo'shimcha shart qo'shadi
@SQLDelete(sql = ("update company set deleted=true where id=?"))//delete komanda berilganda ushbu yozilgan queryga almashtiradi
public class Company extends AbsLongEntity {

    private String name;

    private String address;

    private String phone;

    private LocalDate establishedDate;

    private String stir;

}
