package com.example.CMS.Controller;

import com.example.CMS.DTO.GroupDTO;
import com.example.CMS.Entity.Group;
import com.example.CMS.Entity.Student;
import com.example.CMS.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<Group> createGroup(@RequestBody GroupDTO groupDTO) {
        Group createdGroup = groupService.createGroup(groupDTO);
        return ResponseEntity.status(201).body(createdGroup);
    }

    @GetMapping("/student/{studentID}")
    public ResponseEntity<List<Group>> getGroupsByStudentId(@PathVariable int studentID) {
        List<Group> groups = groupService.getGroupsByStudentId(studentID);
        if (groups.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/group/{groupID}")
    public ResponseEntity<List<Group>> getStudentByGroupId(@PathVariable int groupId) {
        List<Group> groups = groupService.getGroupsByStudentId(groupId);
        if (groups.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(groups);
    }

    // New endpoint to get all students in a group
    @GetMapping("/group/{groupId}/students")
    public ResponseEntity<List<Student>> getStudentsInGroup(@PathVariable int groupId) {
        List<Student> students = groupService.getStudentsInGroup(groupId);
        if (students == null || students.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }
}
