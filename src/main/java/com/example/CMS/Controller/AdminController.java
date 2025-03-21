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
import java.util.Map;

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

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody Map<String, Object> requestBody) {
        // Get the existing admin
        Admin existingAdmin = adminService.getAdminById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        // Get the user associated with the admin
        User user = userService.getUserById(existingAdmin.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Extract user details from request
        Map<String, Object> userMap = (Map<String, Object>) requestBody.get("user");

        user.setNic((String) userMap.get("nic"));
        user.setFirstName((String) userMap.get("firstName"));
        user.setLastName((String) userMap.get("lastName"));
        user.setEmail((String) userMap.get("email"));
        user.setPassword((String) userMap.get("password"));
        user.setPhoneNumber((String) userMap.get("phoneNumber"));
        user.setAddress((String) userMap.get("address"));
        user.setDob((String) userMap.get("dob"));
        user.setGender((String) userMap.get("gender"));
        user.setRole((String) userMap.get("role"));
        user.setStatus((String) userMap.get("status"));

        existingAdmin.setUser(user);

        // Get the new department by deptId
        int deptId = Integer.parseInt((String) requestBody.get("deptId"));
        Department newDepartment = departmentService.getDepartmentById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        existingAdmin.setDepartment(newDepartment);
        System.out.println(newDepartment.getDeptName());
        // Save the updated admin
        return adminService.saveAdmin(existingAdmin);
    }

}
