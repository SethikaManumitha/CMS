package com.example.CMS.Controller;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Department;
import com.example.CMS.Entity.User;
import com.example.CMS.Service.AdminService;
import com.example.CMS.Service.DepartmentService;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    // Create an admin
    @PostMapping
    public Admin createAdmin(@RequestBody Admin adminRequest) {
        // Fetch the user and department entities using their IDs
        User user = userService.getUserById(adminRequest.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        Department department = departmentService.getDepartmentById(adminRequest.getDepartment().getDeptId()).orElseThrow(() -> new RuntimeException("Department not found"));

        // Create and set the user and department in the admin entity
        Admin admin = new Admin();
        admin.setUser(user);
        admin.setDepartment(department);

        // Save the admin entity
        return adminService.saveAdmin(admin);
    }

    // Get an admin by ID
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
    }
}
