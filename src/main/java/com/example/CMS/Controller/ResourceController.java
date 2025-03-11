package com.example.CMS.Controller;

import com.example.CMS.DTO.ResourceRequest;
import com.example.CMS.Entity.Department;
import com.example.CMS.Entity.Lecturer;
import com.example.CMS.Entity.Resource;
import com.example.CMS.Entity.User;
import com.example.CMS.Service.DepartmentService;
import com.example.CMS.Service.ResourceService;
import com.example.CMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Resource adResource(@RequestBody Resource request)
    {
        User user =  userService.getUserById(request.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Department department =  departmentService.getDepartmentById(request.getDepartment().getDeptId())
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Resource resource = new Resource();
        resource.setUser(user);
        resource.setDepartment(department);
        resource.setName(request.getName());
        resource.setType(request.getType());
        resource.setDescription(request.getDescription());
        resource.setCapacity(request.getCapacity());
        resource.setStatus(1);

        return resourceService.addResource(resource);
    }

}
