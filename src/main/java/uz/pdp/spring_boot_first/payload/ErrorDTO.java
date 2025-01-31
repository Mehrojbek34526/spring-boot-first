package uz.pdp.spring_boot_first.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

/**
 Created by: Mehrojbek
 DateTime: 29/01/25 21:00
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDTO {

    private Timestamp timestamp;
    private String error;
    private int status;

}
