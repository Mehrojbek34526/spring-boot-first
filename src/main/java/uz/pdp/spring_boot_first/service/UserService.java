package uz.pdp.spring_boot_first.service;

import uz.pdp.spring_boot_first.enums.RoleEnum;
import uz.pdp.spring_boot_first.payload.UserDTO;
import uz.pdp.spring_boot_first.payload.UserFilterDTO;

import java.util.List;

public interface UserService {
    UserDTO me(String username);

    List<UserDTO> byRole(RoleEnum role);

    List<UserDTO> filter(UserFilterDTO filterDTO);
}
