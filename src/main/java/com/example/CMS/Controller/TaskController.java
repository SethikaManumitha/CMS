package com.example.CMS.Controller;
import com.example.CMS.DTO.ResponseMessage;
import com.example.CMS.DTO.TaskDTO;
import com.example.CMS.Entity.Task;
import com.example.CMS.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDTO) {
        Task createdTask = taskService.createTask(taskDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseMessage("Task added successfully!", createdTask));
    }
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Task>> getTasksByCourseId(@PathVariable int courseId) {
        List<Task> tasks = taskService.getTasksByCourseId(courseId);

        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

}
