package ru.maxima.restclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maxima.restclient.entity.Task;
import ru.maxima.restclient.service.TaskRestService;

import java.util.List;
import java.util.Map;

/*
 * Контроллер для RestApiClient
 */
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class ClientController {

    private final TaskRestService taskRestService;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskRestService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(taskRestService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskRestService.createTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        taskRestService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        taskRestService.updateTask(id, task);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchTask(@PathVariable("id") Long id, @RequestBody Map<String, Object> taskForUpdate) {
        taskRestService.patchTask(id, taskForUpdate);
        return ResponseEntity.ok().build();
    }

}
