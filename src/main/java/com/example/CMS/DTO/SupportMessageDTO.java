package com.example.CMS.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupportMessageDTO {
    private String senderType; // "student" or "lecturer"
    private int senderId;
    private String receiverType; // "admin" or student/lecturer
    private int receiverId;
    private String message;
}
