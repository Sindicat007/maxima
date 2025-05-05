package ru.maxima.restclient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.maxima.restclient.entity.Task;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
 * Сервис клиента RestApiClient
 */
@Service
@RequiredArgsConstructor
public class TaskRestService {
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/tasks";

    public List<Task> getAllTasks() {
        ResponseEntity<Task[]> response = restTemplate.getForEntity(baseUrl, Task[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public Task getTaskById(Long id) {
        ResponseEntity<Task> response = restTemplate.getForEntity(baseUrl + "/" + id, Task.class);
        return Objects.requireNonNull(response.getBody());
    }

    public Task createTask(Task task) {
        ResponseEntity<Task> response = restTemplate.postForEntity(baseUrl, task, Task.class);
        return Objects.requireNonNull(response.getBody());
    }

    public void updateTask(Long id, Task task) {
        restTemplate.put(baseUrl + "/" + id, task);
    }

    public void deleteTask(Long id) {
        restTemplate.delete(baseUrl + "/" + id);
    }

    public void patchTask(Long id, Map<String, Object> task) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(task, headers);

        restTemplate.exchange(
                baseUrl + "/" + id,
                HttpMethod.PATCH,
                entity,
                Void.class);
    }
}
