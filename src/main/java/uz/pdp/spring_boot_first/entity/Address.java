package uz.pdp.spring_boot_first.entity;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import uz.pdp.spring_boot_first.entity.template.AbsLongEntity;

/**
 Created by: Mehrojbek
 DateTime: 05/02/25 19:55
 **/
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@SQLRestriction(value = "deleted=false")
@SQLDelete(sql = "update address set deleted=true where id=?")
@FieldNameConstants
public class Address extends AbsLongEntity {

    private String street;
    private String city;
    private String state;
    private String country;

}
