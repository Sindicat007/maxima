package ru.maxima.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.maxima.jpa.config.AppConfig;
import ru.maxima.jpa.dto.PostDTO;
import ru.maxima.jpa.dto.UserDTO;
import ru.maxima.jpa.service.PostService;
import ru.maxima.jpa.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        PostService postService = context.getBean(PostService.class);

        UserDTO customerDTO = new UserDTO();
        customerDTO.setId(2L);

        PostDTO postDTO = new PostDTO();
        postDTO.setContent("Hello!");
        postDTO.setTitle("My post!");

        // Поиск пользователя по возрасту превышающего заданный
        userService.findUserByAgeMoreThan(14);

        // Поиск пользователей по возрасту превышающего заданный, используя нативный query - запрос
        userService.findAllByAgeGreaterThanCustom(16);

        // Получение пользователя по имени
        userService.findByUsername("Dan");

        // Поиск постов по пользователю с пагинацией
        postService.findByUserWithPageable(customerDTO, 1);

        // Получение постов по части названия
        postService.getPostsByTitle("My");

        // Получение постов по пользователю
        postService.getPostsByUser(customerDTO);

        context.close();
    }
}
