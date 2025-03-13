package com.example.CMS.Service;

import com.example.CMS.Entity.Group;
import com.example.CMS.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public List<Group> getGroupsByStudentId(int studentID) {
        return groupRepository.findByMembers_StudentID(studentID);
    }
}
