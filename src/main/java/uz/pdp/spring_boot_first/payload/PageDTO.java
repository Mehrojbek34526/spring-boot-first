package uz.pdp.spring_boot_first.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.spring_boot_first.enums.PageEnum;
import uz.pdp.spring_boot_first.enums.PermissionEnum;

import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 03/02/25 19:35
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDTO {

    //nomi
    private String title;

    //enumeration
    private PageEnum page;

    //nimalar qila oladi
    private List<PermissionEnum> permissions;

}
