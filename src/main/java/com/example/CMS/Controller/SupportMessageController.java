package com.example.CMS.Controller;

import com.example.CMS.DTO.SupportMessageDTO;
import com.example.CMS.Entity.SupportMessage;
import com.example.CMS.Service.SupportMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/support")
public class SupportMessageController {

    @Autowired
    private SupportMessageService supportMessageService;

    @PostMapping("/send")
    public ResponseEntity<SupportMessage> sendMessage(
            @RequestParam String title,
            @RequestParam String senderType,
            @RequestParam int senderId,
            @RequestParam String receiverType,
            @RequestParam String message,
            @RequestParam String category,
            @RequestParam(required = false) MultipartFile[] files) {

        SupportMessageDTO dto = new SupportMessageDTO(title, senderType, senderId, receiverType, message, category, files);
        SupportMessage messageEntity = supportMessageService.sendMessage(dto);
        return ResponseEntity.ok(messageEntity);
    }

    @GetMapping("/chat")
    public ResponseEntity<List<SupportMessage>> getChat(
            @RequestParam int senderId,
            @RequestParam String senderType,
            @RequestParam String receiverType) {

        List<SupportMessage> chat = supportMessageService.getChatBetween(senderId, senderType, receiverType);
        return ResponseEntity.ok(chat);
    }

    @GetMapping("/allMessages")
    public ResponseEntity<List<SupportMessage>> getAllMessages() {
        List<SupportMessage> messages = supportMessageService.getAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/allSenders")
    public ResponseEntity<List<Integer>> getAllSenders() {
        List<Integer> senders = supportMessageService.getAllSenders();
        return new ResponseEntity<>(senders, HttpStatus.OK);
    }
}
