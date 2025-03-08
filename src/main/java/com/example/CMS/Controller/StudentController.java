package com.example.CMS.Controller;

import com.example.CMS.Entity.Student;
import com.example.CMS.Entity.User;
import com.example.CMS.Service.StudentService;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;


    @PostMapping
    public Student createStudent(@RequestBody Student studentRequest) {

        User user = userService.getUserById(studentRequest.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        Student student = new Student();
        student.setUser(user);
        student.setStudentDegrees(studentRequest.getStudentDegrees());
        student.setStudentCourses(studentRequest.getStudentCourses());
        return studentService.saveStudent(student);
    }
}
