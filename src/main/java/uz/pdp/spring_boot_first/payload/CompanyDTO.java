package uz.pdp.spring_boot_first.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * DTO for {@link uz.pdp.spring_boot_first.entity.Company}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private LocalDate establishedDate;
    private String stir;
}