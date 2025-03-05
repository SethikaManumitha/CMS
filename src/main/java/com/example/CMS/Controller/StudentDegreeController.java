package com.example.CMS.Controller;

import com.example.CMS.DTO.StudentDegreeRequest;
import com.example.CMS.Entity.StudentDegree;
import com.example.CMS.Service.StudentDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student-degree")
public class StudentDegreeController {
    @Autowired
    private StudentDegreeService studentDegreeService;

    @PostMapping("/enroll")
    public ResponseEntity<StudentDegree> enrollStudent(@RequestBody StudentDegreeRequest request) {
        StudentDegree studentDegree = studentDegreeService.enrollStudentInDegree(request);
        return ResponseEntity.ok(studentDegree);
    }
}
