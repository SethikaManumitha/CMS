package com.example.CMS.Controller;

import com.example.CMS.DTO.ResourceRequest;
import com.example.CMS.Entity.Resource;
import com.example.CMS.Service.ResourceService;
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

    @PostMapping("/add")
    public ResponseEntity<Resource> adResource(@RequestBody ResourceRequest request)
    {
        Resource resource=resourceService.addResource(request);
        return ResponseEntity.ok(resource);
    }

}
