package com.example.CMS.Controller;

import com.example.CMS.DTO.StudentDegreeRequest;
import com.example.CMS.Entity.Student;
import com.example.CMS.Entity.StudentDegree;
import com.example.CMS.Service.StudentDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-degree")
public class StudentDegreeController {
    @Autowired
    private StudentDegreeService studentDegreeService;

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollStudent(@RequestBody StudentDegreeRequest request) {
        System.out.println("Received enrollment request: " + request);
        try {
            StudentDegree studentDegree = studentDegreeService.enrollStudentInDegree(request);
            return ResponseEntity.ok("Student successfully enrolled in degree program.");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Failed to enroll student: " + e.getMessage());
        }
    }

    @GetMapping("/program/{programId}/students")
    public ResponseEntity<List<Student>> getStudentsEnrolledInDegree(@PathVariable int programId) {
        try {
            List<Student> students = studentDegreeService.getStudentsEnrolledInDegree(programId);
            return ResponseEntity.ok(students);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }
}
