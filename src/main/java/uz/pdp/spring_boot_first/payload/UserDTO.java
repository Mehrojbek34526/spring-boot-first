package uz.pdp.spring_boot_first.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.spring_boot_first.enums.GenderEnum;
import uz.pdp.spring_boot_first.enums.RoleEnum;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for {@link uz.pdp.spring_boot_first.entity.User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private RoleEnum role;
    private LocalDate birthDate;
    private GenderEnum gender;
    private AddressDTO address;
}