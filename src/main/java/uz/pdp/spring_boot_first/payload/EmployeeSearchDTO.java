package uz.pdp.spring_boot_first.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 Created by: Mehrojbek
 DateTime: 29/01/25 21:18
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeSearchDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate birthDate;

}
