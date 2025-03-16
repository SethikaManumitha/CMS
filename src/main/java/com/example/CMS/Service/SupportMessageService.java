package com.example.CMS.Service;

import com.example.CMS.DTO.SupportMessageDTO;
import com.example.CMS.Entity.SupportMessage;
import com.example.CMS.Repository.SupportMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class SupportMessageService {

    @Autowired
    private SupportMessageRepository supportMessageRepository;

    private static final String FILE_UPLOAD_DIR = "D:\\CMS\\frontend\\CMS_Front\\uploads\\support";

    public SupportMessage sendMessage(SupportMessageDTO dto) {
        File uploadDir = new File(FILE_UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileName = null;

        if (dto.getFiles() != null) {
            for (MultipartFile file : dto.getFiles()) {
                // Generate a unique file name using the current timestamp
                String timestamp = String.valueOf(System.currentTimeMillis());
                String fileExtension = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf('.'));
                String uniqueFileName = timestamp + fileExtension;  // Use timestamp as file name with original extension

                File targetFile = new File(uploadDir, uniqueFileName);

                try {
                    file.transferTo(targetFile);

                    fileName = uniqueFileName;
                } catch (IOException e) {
                    throw new RuntimeException("Failed to upload file: " + file.getOriginalFilename(), e);
                }
            }
        }

        // Create and save the support message
        SupportMessage message = new SupportMessage();
        message.setTitle(dto.getTitle());
        message.setSenderType(dto.getSenderType());
        message.setSenderId(dto.getSenderId());
        message.setReceiverType(dto.getReceiverType());
        message.setMessage(dto.getMessage());
        message.setCategory(dto.getCategory());
        message.setFilePath(fileName);
        message.setTimestamp(LocalDateTime.now());

        return supportMessageRepository.save(message);
    }


    public List<SupportMessage> getChatBetween(int senderId, String senderType, String receiverType) {
        return supportMessageRepository.findBySenderIdAndSenderTypeAndReceiverTypeOrderByTimestampAsc(
                senderId, senderType, receiverType
        );
    }

    public List<SupportMessage> getAllMessages() {
        return supportMessageRepository.findAll();
    }

    public List<Integer> getAllSenders() {
        return supportMessageRepository.findDistinctSenders();
    }
}
