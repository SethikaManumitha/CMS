package com.example.CMS.Controller;

import com.example.CMS.Entity.Group;
import com.example.CMS.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<Group> createGroup(@RequestBody Group group) {
        Group createdGroup = groupService.createGroup(group);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentID}")
    public ResponseEntity<List<Group>> getGroupsByStudentId(@PathVariable int studentID) {
        List<Group> groups = groupService.getGroupsByStudentId(studentID);
        if (groups.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(groups);
    }
}
