package com.example.CMS.Repository;

import com.example.CMS.Entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findByMembers_StudentID(int studentID);
}
