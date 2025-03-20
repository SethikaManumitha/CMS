package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReservationEventResponse {
    private int reservationID;
    private int eventID;
    private String eventName;
    private int roomID;
    private String roomName;
    private String date;
    private String startTime;
    private String endTime;
}
