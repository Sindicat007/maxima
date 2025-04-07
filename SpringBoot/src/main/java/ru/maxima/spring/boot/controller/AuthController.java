package ru.maxima.spring.boot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.maxima.spring.boot.entity.UserEntity;
import ru.maxima.spring.boot.service.UserService;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping()
    public String getHome() {
        return "redirect:/books";
    }

    @GetMapping("/register")
    public String addForm(Model model) {
        model.addAttribute("userEntity", new UserEntity());
        return "addUser";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@ModelAttribute("userEntity") UserEntity user) {
        if (userService.getUser(user).isPresent()) {
            return "Пользователь уже существует!";
        }

        userService.createUser(user);
        return "Пользователь зарегистрирован!";
    }
}
