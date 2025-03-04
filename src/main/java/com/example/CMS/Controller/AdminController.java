package com.example.CMS.Controller;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling degree Admin related API endpoints.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

    @GetMapping("/getAdmin/{id}")
    public Admin getAdminById(@PathVariable int id) {
        return adminService.getAdminById(id);
    }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PutMapping("/updateAdmin/{id}")
    public Admin updateAdmin(@PathVariable int id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public void deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
    }
}
