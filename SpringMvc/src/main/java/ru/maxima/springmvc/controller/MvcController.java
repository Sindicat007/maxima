package ru.maxima.springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MvcController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("message", "Hello my friends");
        return "index";
    }
}
