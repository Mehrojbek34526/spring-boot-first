package uz.pdp.spring_boot_first.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Version;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import uz.pdp.spring_boot_first.entity.template.AbsLongEntity;

import java.time.LocalDate;

/**
 Created by: Mehrojbek
 DateTime: 07/02/25 19:35
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SQLRestriction(value = "deleted=false")//bazadan ma'lumot olayotganda where ga qo'shimcha shart qo'shadi
@SQLDelete(sql = ("update bank_card set deleted=true where id=?"))
public class BankCard extends AbsLongEntity {

    private String cardNumber;

    private LocalDate expiryDate;

    private String holderName;

    private Long balance;

    @Version
    private long version;

}
