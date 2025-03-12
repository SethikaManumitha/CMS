package com.example.CMS.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventAttendanceDTO {
    private int eventId;
    private int userId;
    private String date;
    private String time;
}
