package com.example.CMS.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO {
    private String date;
    private String closingDate;
    private String message;
    private String type;
    private int adminId;
}