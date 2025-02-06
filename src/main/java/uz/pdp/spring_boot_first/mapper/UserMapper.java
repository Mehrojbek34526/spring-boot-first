package uz.pdp.spring_boot_first.mapper;

import org.mapstruct.Mapper;
import uz.pdp.spring_boot_first.entity.User;
import uz.pdp.spring_boot_first.payload.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    List<UserDTO> toDTO(List<User> users);

}
