package com.example.CMS.Service;


import com.example.CMS.DTO.ResourceRequest;
import com.example.CMS.Entity.Department;
import com.example.CMS.Entity.Resource;
import com.example.CMS.Entity.User;
import com.example.CMS.Repository.DepartmentRepo;
import com.example.CMS.Repository.ResourceRepo;
import com.example.CMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepo resourceRepository;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private DepartmentRepo departmentRepository;

    public Resource addResource(ResourceRequest request){
        User user=userRepository.findById(request.getUserID())
                .orElseThrow(() -> new RuntimeException("user not found"));
        Department department=departmentRepository.findById(request.getDepartmentID())
                .orElseThrow(() -> new RuntimeException("department not found"));
        Resource resource=new Resource();
        resource.setDepartment(department);
        resource.setUser(user);
        return resourceRepository.save(resource);
    }
}
