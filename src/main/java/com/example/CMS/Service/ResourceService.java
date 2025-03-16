package com.example.CMS.Service;


import com.example.CMS.Entity.Resource;
import com.example.CMS.Repository.DepartmentRepo;
import com.example.CMS.Repository.ResourceRepo;
import com.example.CMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepo resourceRepository;

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private DepartmentRepo departmentRepository;

    // Changed resource
    public Resource addResource(Resource resource){
        return resourceRepository.save(resource);
    }

    public Optional<Resource> getResourceById(int id) {
        return resourceRepository.findById(id);
    }

    public List<Resource> getAllResource() {
        return resourceRepository.findAll();
    }

    public List<Resource> getAllAvailableResources() {
        return resourceRepository.findByStatus(1);
    }



}
