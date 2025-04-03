package ru.maxima.spring.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.maxima.spring.boot.service.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/home")
    public String home() {
            return "Hello!";
    }

//    @PostMapping("/register")
//    public String register(@RequestBody UserEntity user) {
//        if (userService.getUser(user).isPresent()) {
//            return "Пользователь уже существует!";
//        }
//
//        userService.createUser(user);
//        return "Пользователь зарегистрирован!";
//    }
}
