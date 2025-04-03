package ru.maxima.spring.boot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/home")
    public String getAdminData() {
        return "Hi admin";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
