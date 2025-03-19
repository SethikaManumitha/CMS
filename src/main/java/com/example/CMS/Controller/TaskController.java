package com.example.CMS.Controller;

import com.example.CMS.DTO.TaskDTO;
import com.example.CMS.DTO.TaskResponseDTO;
import com.example.CMS.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(
            @RequestParam String title,
            @RequestParam String dueTime,
            @RequestParam String dueDate,
            @RequestParam String type,
            @RequestParam String description,
            @RequestParam(required = false) MultipartFile[] docUrl,
            @RequestParam String status,
            @RequestParam int classID,
            @RequestParam int lecturerId
    ) {
        TaskResponseDTO responseDTO = taskService.createTask(
                new TaskDTO(title, dueTime, dueDate, type, description, docUrl, status, classID, lecturerId)
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks() {
        List<TaskResponseDTO> tasks = taskService.getAllTasks();

        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<TaskResponseDTO>> getTasksByCourseId(@PathVariable int courseId) {
        List<TaskResponseDTO> tasks = taskService.getTasksByCourseId(courseId).stream()
                .map(task -> new TaskResponseDTO(
                        task.getTitle(),
                        task.getDue_time(),
                        task.getDueDate(),
                        task.getType(),
                        task.getDescription(),
                        task.getDocUrl(),
                        task.getStatus(),
                        task.getAClass().getClassID(),
                        task.getLecturer().getLecturerID()
                ))
                .toList();

        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }
}
