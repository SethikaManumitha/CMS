package com.example.CMS.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class EventRequest {
    private String name;
    private String description;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String eventType;
    private String organizer;
    private int maxCapacity;
    private LocalDate registerDeadline;
    private String status;
}
