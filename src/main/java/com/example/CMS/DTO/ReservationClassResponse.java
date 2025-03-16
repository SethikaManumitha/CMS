package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReservationClassResponse {
    private int reservationID;
    private int classID;
    private int courseID;
    private String courseName;
    private int lecturerID;
    private String lecturerName;
    private int roomID;
    private String roomName;
    private String day;
    private String startTime;
    private String endTime;
}
