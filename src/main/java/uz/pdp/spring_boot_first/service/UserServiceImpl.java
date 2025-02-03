package uz.pdp.spring_boot_first.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot_first.enums.PageEnum;
import uz.pdp.spring_boot_first.payload.PageDTO;
import uz.pdp.spring_boot_first.payload.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static uz.pdp.spring_boot_first.enums.PermissionEnum.*;

/**
 Created by: Mehrojbek
 DateTime: 03/02/25 19:45
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO me() {

        //roli yoki permissioniga qarab pagelarini yasab berish kerak
        List<PageDTO> pages = new ArrayList<>();
        pages.add(new PageDTO(
                PageEnum.DOCTOR.name().toLowerCase(),
                PageEnum.DOCTOR,
                List.of(VIEW_DOCTOR, ADD_DOCTOR, EDIT_DOCTOR)
        ));
        pages.add(new PageDTO(
                PageEnum.PATIENT.name().toLowerCase(),
                PageEnum.PATIENT,
                List.of(VIEW_PATIENT, ADD_PATIENT, EDIT_PATIENT)
        ));

        return new UserDTO(
                UUID.randomUUID(),
                "John",
                "john@gmail.com",
                pages
        );
    }
}
