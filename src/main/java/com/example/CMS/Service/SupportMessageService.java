package com.example.CMS.Service;

import com.example.CMS.DTO.SupportMessageDTO;
import com.example.CMS.Entity.SupportMessage;
import com.example.CMS.Repository.SupportMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SupportMessageService {

    @Autowired
    private SupportMessageRepository supportMessageRepository;

    public SupportMessage sendMessage(SupportMessageDTO dto) {
        SupportMessage message = new SupportMessage();
        message.setSenderType(dto.getSenderType());
        message.setSenderId(dto.getSenderId());
        message.setReceiverType(dto.getReceiverType());
        message.setReceiverId(dto.getReceiverId());
        message.setMessage(dto.getMessage());
        message.setTimestamp(LocalDateTime.now());
        return supportMessageRepository.save(message);
    }

    public List<SupportMessage> getChatBetween(int senderId, int receiverId, String senderType, String receiverType) {
        return supportMessageRepository.findBySenderIdAndReceiverIdAndSenderTypeAndReceiverTypeOrderByTimestampAsc(
                senderId, receiverId, senderType, receiverType
        );
    }
    public List<SupportMessage> getAllMessages() {
        return supportMessageRepository.findAll();
    }
    public List<Integer> getAllSenders() {
        return supportMessageRepository.findDistinctSenders();
    }


}
