package com.example.CMS.Controller;

import com.example.CMS.DTO.StudentResponseDTO;
import com.example.CMS.Entity.Student;
import com.example.CMS.Entity.StudentCourse;
import com.example.CMS.Entity.StudentDegree;
import com.example.CMS.Entity.User;
import com.example.CMS.Service.StudentService;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    // Create a new student
    @PostMapping
    public Student createStudent(@RequestBody Student studentRequest) {
        User user = userService.getUserById(studentRequest.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        Student student = new Student();
        student.setUser(user);
        student.setStudentDegrees(studentRequest.getStudentDegrees());
        student.setStudentCourses(studentRequest.getStudentCourses());
        return studentService.saveStudent(student);
    }

    // Get a student by ID and return StudentResponseDTO
    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable int id) {
        return studentService.getStudentByIDResponse(id).orElse(null);
    }

    // Get all students
    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get courses for a student by student ID
    @GetMapping("/course/{id}")
    public Optional<List<StudentCourse>> getAllCourses(@PathVariable int id) {
        Student student = studentService.getStudentById(id).orElse(null);
        if (student != null) {
            return Optional.ofNullable(student.getStudentCourses());
        } else {
            return Optional.empty();
        }
    }

    @GetMapping("/byUser/{userID}")
    public ResponseEntity<Student> getStudentByUserID(@PathVariable int userID) {
        Student student = studentService.getStudentByUserID(userID);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }

    // Update a student's information by ID
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student studentRequest) {
        Student existingStudent = studentService.getStudentById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        User user = userService.getUserById(existingStudent.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));

        // Update user's information
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
        existingStudent.setStudentDegrees(studentRequest.getStudentDegrees());
        existingStudent.setStudentCourses(studentRequest.getStudentCourses());

        return studentService.saveStudent(existingStudent);
    }
}
