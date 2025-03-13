package http.controller;

import http.User;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/json")
    public String recieveJson(@RequestBody User user) {
        return "Received user: " + user.name() + " " + user.age();
    }
    @GetMapping("/headers")
    public String readHeaders(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent: " + userAgent;
    }

    @GetMapping("/user/profile")
    public String userProfile(@CookieValue(value = "username") String username) {
        if (username == null) {
            return "Guest";
        }
      return "User profile for "  + username;
    }
}
