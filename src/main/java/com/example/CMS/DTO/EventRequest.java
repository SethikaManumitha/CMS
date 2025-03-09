package com.example.CMS.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventRequest {
    private String name;
    private String description;
    private String date;
    private String startTime;
    private String endTime;
    private String eventType;
    private String organizer;
    private int MaxCapacity;
    private String RegisterDeadline;
    private String status;
}
