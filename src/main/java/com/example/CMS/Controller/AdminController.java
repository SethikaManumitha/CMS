package com.example.CMS.Controller;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Entity.Department;
import com.example.CMS.Entity.User;
import com.example.CMS.Service.AdminService;
import com.example.CMS.Service.DepartmentService;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //get all admins
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
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

    // Update an admin by ID
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody Admin adminRequest) {
        // Fetch the admin entity by ID
        Admin existingAdmin = adminService.getAdminById(id).orElseThrow(() -> new RuntimeException("Admin not found"));

        // Fetch the user and department entities using their IDs
        User user = userService.getUserById(adminRequest.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));
        Department department = departmentService.getDepartmentById(adminRequest.getDepartment().getDeptId()).orElseThrow(() -> new RuntimeException("Department not found"));

        existingAdmin.setUser(user);
        existingAdmin.setDepartment(department);

        return adminService.saveAdmin(existingAdmin);
    }
}
