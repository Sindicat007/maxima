package spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Контроллер для общей страницы
 */

@Controller
@RequestMapping("/public")
public class HomeController {

    @GetMapping
    public String publicHomePage() {
        return "homePage";
    }
}
