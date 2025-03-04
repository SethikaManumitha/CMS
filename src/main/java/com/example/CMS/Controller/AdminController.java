package com.example.CMS.Controller;

import com.example.CMS.Entity.Admin;
import com.example.CMS.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling degree Admin related API endpoints.
 * Manages HTTP requests related to degree admin entity operations.
 */
@RestController
@RequestMapping("/admin") // Added request mapping
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }
}
