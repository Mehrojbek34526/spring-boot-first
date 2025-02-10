package uz.pdp.spring_boot_first.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.spring_boot_first.enums.RoleEnum;
import uz.pdp.spring_boot_first.payload.UserDTO;
import uz.pdp.spring_boot_first.payload.UserFilterDTO;
import uz.pdp.spring_boot_first.payload.UserShortInfo;
import uz.pdp.spring_boot_first.repository.UserRepository;
import uz.pdp.spring_boot_first.service.UserService;

import java.util.List;

/**
 Created by: Mehrojbek
 DateTime: 03/02/25 19:44
 **/

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/short-info")
    public List<UserShortInfo> shortInfo(){
        return userRepository.getUserShortInfo();
    }

    @GetMapping("/me")
    public UserDTO me(@RequestParam String username) {
        log.info(">> me ");
        return userService.me(username);
    }

    @GetMapping("/by-role")
    public List<UserDTO> byRole(@RequestParam RoleEnum role) {
        log.info(">> byRole ");
        return userService.byRole(role);
    }

    @GetMapping("/filter")
    public List<UserDTO> filter(UserFilterDTO filterDTO) {
        log.info(">> filter {}", filterDTO);
        return userService.filter(filterDTO);
    }

}
