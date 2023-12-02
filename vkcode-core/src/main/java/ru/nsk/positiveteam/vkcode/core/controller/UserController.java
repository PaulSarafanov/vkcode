package ru.nsk.positiveteam.vkcode.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.positiveteam.vkcode.api.dto.UserDto;

@RestController
public class UserController {
    @GetMapping("/user")
    public UserDto getUser() {
        return new UserDto();
    }
}
