package com.example.CMS.Service;


import com.example.CMS.Entity.Resource;
import com.example.CMS.Repository.DepartmentRepo;
import com.example.CMS.Repository.ResourceRepo;
import com.example.CMS.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<String, Integer> getResourcesByCapacityCount() {
        List<Resource> resources = resourceRepository.findAll();

        // Initialize a map to hold the counts for each category
        Map<String, Integer> capacityCount = new HashMap<>();
        capacityCount.put("small", 0);
        capacityCount.put("medium", 0);
        capacityCount.put("large", 0);
        capacityCount.put("extra large", 0);

        // Iterate over resources and count them based on capacity
        for (Resource resource : resources) {
            int capacity = resource.getCapacity();
            if (capacity < 30) {
                capacityCount.put("small", capacityCount.get("small") + 1);
            } else if (capacity >= 30 && capacity <= 60) {
                capacityCount.put("medium", capacityCount.get("medium") + 1);
            } else if (capacity > 60 && capacity <= 100) {
                capacityCount.put("large", capacityCount.get("large") + 1);
            } else {
                capacityCount.put("extra large", capacityCount.get("extra large") + 1);
            }
        }

        return capacityCount;
    }


}
