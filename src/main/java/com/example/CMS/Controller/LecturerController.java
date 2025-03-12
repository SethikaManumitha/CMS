package com.example.CMS.Controller;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Entity.Department;
import com.example.CMS.Entity.User;
import com.example.CMS.Service.LecturerService;
import com.example.CMS.Service.DepartmentService;
import com.example.CMS.Service.LecturerService;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturers")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    // Create a Lecturer
    @PostMapping
    public Lecturer createLecturer(@RequestBody Lecturer lecturerRequest) {
        // Ensure the LecturerRequest contains a valid user and department
        if (lecturerRequest.getUser() == null || lecturerRequest.getDepartment() == null) {
            throw new RuntimeException("User or Department must not be null");
        }

        // Fetch the user and department entities using their IDs
        User user = userService.getUserById(lecturerRequest.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Department department = departmentService.getDepartmentById(lecturerRequest.getDepartment().getDeptId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        // Create and set the user and department in the Lecturer entity
        Lecturer lecturer = new Lecturer();
        lecturer.setUser(user);
        lecturer.setDepartment(department);
        lecturer.setDesignation(lecturerRequest.getDesignation());
        lecturer.setSpecialisation(lecturerRequest.getSpecialisation());
        lecturer.setHighestQualification(lecturerRequest.getHighestQualification());

        // Save the Lecturer entity and return it
        return lecturerService.saveLecturer(lecturer);
    }

    // Get a Lecturer by ID
    @GetMapping("/{id}")
    public Lecturer getLecturerById(@PathVariable int id) {
        return lecturerService.getLecturerById(id).orElse(null);
    }

    //get all lecturers
    @GetMapping
    public List<Lecturer> getAllLecturers() {
        return lecturerService.getAllLecturers();
    }
    // Delete a Lecturer by ID
    @DeleteMapping("/{id}")
    public void deleteLecturer(@PathVariable int id) {
        lecturerService.deleteLecturer(id);
    }


}
