package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TimeTableDTO {
    private String day;
    private String startTime;
    private String endTime;
    private String courseName;
    private String roomName;
}
