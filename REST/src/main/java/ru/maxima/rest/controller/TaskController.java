package ru.maxima.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.maxima.rest.entity.Task;
import ru.maxima.rest.repository.TaskRepository;

import java.net.URI;
import java.util.List;
import java.util.Map;

/*
 * Контроллер для работы с задачами
 */
@RequiredArgsConstructor
@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        return taskRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        taskRepository.save(task);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(task.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task taskForUpdate) {

        return taskRepository.findById(id)
                .map(task -> {
                    taskForUpdate.setId(id);
                    taskRepository.save(taskForUpdate);
                    return ResponseEntity.ok(task);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> patchTask(@PathVariable("id") Long id, @RequestBody Map<String, Object> taskForUpdate) {
        return taskRepository.findById(id)
                .map(task -> {
                    taskForUpdate.forEach((key, value) -> {
                        switch (key) {
                            case "title" -> task.setTitle((String) value);
                            case "description" -> task.setDescription((String) value);
                            case "completed" -> task.setCompleted((Boolean) value);
                            default -> throw new IllegalStateException("Unexpected value: " + key);
                        }
                    });
                    return ResponseEntity.ok(taskRepository.save(task));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
