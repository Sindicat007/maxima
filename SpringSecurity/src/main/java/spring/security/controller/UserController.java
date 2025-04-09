package spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Контроллер для страницы пользователя
 */

@Controller
@RequestMapping("/user")
@EnableMethodSecurity
public class UserController {

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping
    public String userPage() {
        return "userPage";
    }
}
