package com.example.CMS.Controller;

import com.example.CMS.Entity.GroupMessage;
import com.example.CMS.Service.GroupMessageService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupMessages")
public class GroupMessageController {

    @Autowired
    private GroupMessageService groupMessageService;

    @PostMapping("/send")
    public ResponseEntity<GroupMessage> sendMessage(@RequestBody GroupMessage groupMessage) {
        GroupMessage sentMessage = groupMessageService.sendMessage(groupMessage);
        return new ResponseEntity<>(sentMessage, HttpStatus.CREATED);
    }

    @GetMapping("/messages/{groupId}")
    public ResponseEntity<List<GroupMessage>> getMessagesByGroup(@PathVariable int groupId) {
        List<GroupMessage> messages = groupMessageService.getMessagesByGroupId(groupId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
    @PostMapping("/by-group")
    public List<GroupMessage> getMessagesByGroup(@RequestBody GroupMessageRequest request) {
        return groupMessageService.getMessagesByGroupId(request.getGroupId());
    }

    @Getter
    @Setter
    static class GroupMessageRequest {
        private int groupId;
    }
}
