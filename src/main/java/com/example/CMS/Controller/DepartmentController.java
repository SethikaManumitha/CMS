package com.example.CMS.Controller;

import com.example.CMS.Entity.Department;
import com.example.CMS.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling department-related API endpoints.
 * Manages HTTP requests related to department entity operations.
 */

@RestController
@RequestMapping("/department") // Added request mapping
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * Handles HTTP POST requests to add a new department.
     * @param department department entity received in the request body
     * @return Saved department entity
     */

    @PostMapping("/addDepartment")
    public Department postDetails(@RequestBody Department department)
    {

        return departmentService.saveDetails(department);
    }
}
