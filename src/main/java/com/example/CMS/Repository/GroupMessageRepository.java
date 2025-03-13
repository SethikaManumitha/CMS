package com.example.CMS.Repository;

import com.example.CMS.Entity.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupMessageRepository extends JpaRepository<GroupMessage, Integer> {

    @Query(value = "SELECT * FROM group_messages WHERE group_id = :groupId", nativeQuery = true)
    List<GroupMessage> findAllMessagesByGroupId(@Param("groupId") int groupId);
}
