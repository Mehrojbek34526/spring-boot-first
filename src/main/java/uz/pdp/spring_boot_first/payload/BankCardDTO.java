package uz.pdp.spring_boot_first.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * DTO for {@link uz.pdp.spring_boot_first.entity.BankCard}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCardDTO implements Serializable {
    private Long id;
    private String cardNumber;
    private LocalDate expiryDate;
    private String holderName;
    private Long balance;

}