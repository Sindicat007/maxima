package ru.maxima.spring.boot.restController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Контроллер, предназначенный для работы с пользователями.
 *
 * @author Sindicat
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/home")
    public String getUserData() {
        return "Hi user!";
    }

}
