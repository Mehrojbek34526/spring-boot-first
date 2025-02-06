package uz.pdp.spring_boot_first.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.spring_boot_first.enums.GenderEnum;
import uz.pdp.spring_boot_first.enums.RoleEnum;

import java.time.LocalDate;

/**
 Created by: Mehrojbek
 DateTime: 05/02/25 20:50
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFilterDTO {

    private String firstName;

    private String lastName;

    private String username;

    private RoleEnum role;

    private LocalDate birthDateFrom;

    private LocalDate birthDateTo;

    private GenderEnum gender;

    //address
    private String city;

    private String country;
}
