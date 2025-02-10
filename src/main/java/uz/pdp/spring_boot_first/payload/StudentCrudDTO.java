package uz.pdp.spring_boot_first.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import uz.pdp.spring_boot_first.enums.GenderEnum;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link uz.pdp.spring_boot_first.entity.Student}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentCrudDTO implements Serializable {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private GenderEnum gender;
    private String email;
}