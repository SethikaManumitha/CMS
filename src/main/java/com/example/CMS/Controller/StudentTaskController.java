package com.example.CMS.Controller;

import com.example.CMS.Entity.StudentTask;
import com.example.CMS.Service.StudentTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-tasks")
public class StudentTaskController {

    @Autowired
    private StudentTaskService studentTaskService;

    @PostMapping
    public ResponseEntity<StudentTask> createStudentTask(@RequestBody StudentTask studentTask) {
        StudentTask createdStudentTask = studentTaskService.createStudentTask(studentTask);
        return new ResponseEntity<>(createdStudentTask, HttpStatus.CREATED);
    }

    @GetMapping("/{studentTaskId}")
    public ResponseEntity<StudentTask> getStudentTask(@PathVariable int studentTaskId) {
        StudentTask studentTask = studentTaskService.getStudentTask(studentTaskId);
        if (studentTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentTask);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<StudentTask>> getStudentTasksByTaskId(@PathVariable int taskId) {
        List<StudentTask> studentTasks = studentTaskService.getStudentTasksByTaskId(taskId);
        if (studentTasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentTasks);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentTask>> getStudentTasksByStudentId(@PathVariable int studentId) {
        List<StudentTask> studentTasks = studentTaskService.getStudentTasksByStudentId(studentId);
        if (studentTasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(studentTasks);
    }

    @GetMapping("/task/{taskId}/student/{studentId}")
    public ResponseEntity<StudentTask> getStudentTaskByTaskIdAndStudentId(
            @PathVariable int taskId, @PathVariable int studentId) {
        StudentTask studentTask = studentTaskService.getStudentTaskByTaskIdAndStudentId(taskId, studentId);
        if (studentTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentTask);
    }
}
