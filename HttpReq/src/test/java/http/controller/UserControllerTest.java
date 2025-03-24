package http.controller;

import http.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    @DisplayName("Проверка главной страницы")
    void home() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());

    }

    @Test
    @DisplayName("Проверка вывода сообщения")
    void greet() throws Exception {
        mockMvc.perform(get("/users?name={name}", "John"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Проверка поиска по имени и возрасту")
    void search() throws Exception {
        mockMvc.perform(get("/users").param("name", "John")
                        .param("age", "30"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Проверка вывода юзера по его ID")
    void getUser() throws Exception {
        mockMvc.perform(get("/user/{id}", 1))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Проверка вывода JSON")
    void receiveJson() throws Exception {
        User user = new User("John", 30);
        mockMvc.perform(get("/json", user.name(), user.age())
                .accept(MediaType.APPLICATION_JSON)).andReturn();
    }

    @Test
    @DisplayName("Проверка чтения заголовков")
    void readHeaders() throws Exception {
        mockMvc.perform(get("/headers")
                        .header("User-Agent", "Chrome"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Проверка вывода куки")
    void userProfile() throws Exception {
        mockMvc.perform(get("/user/profile"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Проверка установки куки")
    void setCookie() throws Exception {
        mockMvc.perform(get("/set-cookie"))
                .andExpect(status().isOk());
    }

}