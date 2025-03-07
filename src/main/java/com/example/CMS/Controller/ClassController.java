package com.example.CMS.Controller;


import com.example.CMS.DTO.ClassRequest;
import com.example.CMS.Entity.Class;
import com.example.CMS.Service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classes")
public class ClassController {
    @Autowired
    private ClassService classService;

    @PostMapping("/class")
    public ResponseEntity<Class> addClass(@RequestBody ClassRequest request) {
        Class classes= classService.CreateClass(request);
        return ResponseEntity.ok(classes);
    }
}
