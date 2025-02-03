package uz.pdp.spring_boot_first.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.spring_boot_first.payload.UserDTO;
import uz.pdp.spring_boot_first.service.UserService;

import java.util.logging.Logger;

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

    @GetMapping("/me")
    public UserDTO me(){
        log.info(">> me ");
        return userService.me();
    }

}
