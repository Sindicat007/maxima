package ru.maxima.dispatcherservlet.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AppController {

    @GetMapping
    public String home(){
        return "home";
    }
    @GetMapping("/about")
    public String hello(){
        return "about";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
}
