package http.controller;

import http.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/users")
    public String greet(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @GetMapping("/user/search")
    public String search(@RequestParam("name") String name, @RequestParam("age") int age) {
        return String.format("Searching user by name %s and age %d ", name, age);
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id) {
        return String.format("User with id %d", id);
    }

    @GetMapping("/json")
    public String receiveJson(@RequestBody User user) {
        return "Received user: " + user.name() + " " + user.age();
    }

    @GetMapping("/headers")
    public String readHeaders(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent: " + userAgent;
    }

    @GetMapping("/user/profile")
    public String userProfile(@CookieValue(value = "username", required = false) String username) {
        if (username == null) {
            return "Guest";
        }
        return "User profile for " + username;
    }

    @GetMapping("/set-cookie")
    public Map<String, String> setCookie(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from("username", "Alex")
                .maxAge(3600) // Срок жизни куки (в секундах)
                .path("/") // Путь, на котором куки будет действовать
                .build();
        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        Map<String, String> res = new HashMap<>();
        res.put("message", "Cookie set successfully");
        return res;
    }
}
