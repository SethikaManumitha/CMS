package com.example.CMS.Controller;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Department;
import com.example.CMS.Entity.Student;
import com.example.CMS.Entity.User;
import com.example.CMS.Service.StudentService;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Get an admin by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id).orElse(null);
    }

    //get all students
    @GetMapping
    public List<Student> getAllAdmins() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    // Update an student by ID
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student studentRequest) {
        Student existingStudent = studentService.getStudentById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        System.out.println(existingStudent.getUser().getId());
        User user = userService.getUserById(existingStudent.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));

        user.setNic(studentRequest.getUser().getNic());
        user.setFirstName(studentRequest.getUser().getFirstName());
        user.setLastName(studentRequest.getUser().getLastName());
        user.setEmail(studentRequest.getUser().getEmail());
        user.setPassword(studentRequest.getUser().getPassword());
        user.setPhoneNumber(studentRequest.getUser().getPhoneNumber());
        user.setAddress(studentRequest.getUser().getAddress());
        user.setDob(studentRequest.getUser().getDob());
        user.setGender(studentRequest.getUser().getGender());
        user.setRole(studentRequest.getUser().getRole());
        user.setStatus(studentRequest.getUser().getStatus());

        existingStudent.setUser(user);

        return studentService.saveStudent(existingStudent);
    }
}
