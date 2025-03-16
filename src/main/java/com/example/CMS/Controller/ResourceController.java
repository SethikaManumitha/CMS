package com.example.CMS.Controller;

import com.example.CMS.DTO.ResourceRequest;
import com.example.CMS.Entity.Department;
import com.example.CMS.Entity.Resource;
import com.example.CMS.Entity.User;
import com.example.CMS.Service.DepartmentService;
import com.example.CMS.Service.ResourceService;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Resource addResource(@RequestBody ResourceRequest request) {
        User user = userService.getUserById(request.getUserID())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Department department = departmentService.getDepartmentById(request.getDepartmentID())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Resource resource = new Resource();
        resource.setUser(user);
        resource.setDepartment(department);
        resource.setName(request.getName());
        resource.setType(request.getType());
        resource.setDescription(request.getDescription());
        resource.setCapacity(request.getCapacity());
        resource.setStatus(request.getStatus());

        return resourceService.addResource(resource);
    }

    @GetMapping
    public List<Resource> getAllResource() {
        return  resourceService.getAllResource();
    }

    @GetMapping("/available")
    public List<Resource> getAllAvailableResources() {
        return resourceService.getAllAvailableResources();
    }
}
