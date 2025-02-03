package uz.pdp.spring_boot_first.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 Created by: Mehrojbek
 DateTime: 03/02/25 19:34
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private UUID id;

    private String name;

    private String email;

    private List<PageDTO> pages;

}
