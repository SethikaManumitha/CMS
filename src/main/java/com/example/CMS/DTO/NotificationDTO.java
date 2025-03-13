package com.example.CMS.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private String notification;
    private String date;
    private String time;
    private String userType; // "student", "lecturer", "admin", "all"
    private int adminId;
}
