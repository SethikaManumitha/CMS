package com.example.CMS.DTO;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupportMessageDTO {
    private String title;
    private String senderType;
    private int senderId;
    private String receiverType;
    private String message;
    private String category;
    private MultipartFile[] files;
}
