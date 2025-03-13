package com.example.CMS.Service;

import com.example.CMS.Entity.GroupMessage;
import com.example.CMS.Repository.GroupMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMessageService {

    @Autowired
    private GroupMessageRepository groupMessageRepository;

    public GroupMessage sendMessage(GroupMessage groupMessage) {
        return groupMessageRepository.save(groupMessage);
    }

    public List<GroupMessage> getMessagesByGroupId(int groupId) {
        return groupMessageRepository.findAllMessagesByGroupId(groupId);
    }

}
