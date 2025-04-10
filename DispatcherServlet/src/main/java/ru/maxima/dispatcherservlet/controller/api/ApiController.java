package ru.maxima.dispatcherservlet.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ApiController {

    @GetMapping(value = "/courses")
    public List<String> getCourses(){
        return List.of("Java","Spring","Hibernate","Maven");
    }
}
