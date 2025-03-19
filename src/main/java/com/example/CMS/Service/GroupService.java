package com.example.CMS.Service;

import com.example.CMS.DTO.GroupDTO;
import com.example.CMS.Entity.Group;
import com.example.CMS.Entity.Student;
import com.example.CMS.Repository.GroupRepository;
import com.example.CMS.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepo studentRepository;

    public Group createGroup(GroupDTO groupDTO) {
        Group group = new Group();
        group.setGroupName(groupDTO.getGroupName());
        group.setDescription(groupDTO.getDescription());

        List<Student> members = groupDTO.getMemberIds().stream()
                .map(id -> studentRepository.findById(id).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        group.setMembers(members);
        return groupRepository.save(group);
    }

    public List<Group> getGroupsByStudentId(int studentID) {
        return groupRepository.findByMembers_StudentID(studentID);
    }

    public List<Student> getStudentsInGroup(int groupId) {
        Group group = groupRepository.findById(groupId).orElse(null);
        if (group != null) {
            return group.getMembers();
        }
        return null;
    }
}
