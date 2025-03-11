package com.example.CMS.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvailabilityRequest {
    private int resourceId;
    private String date;
    private String startTime;
    private String endTime;
}
