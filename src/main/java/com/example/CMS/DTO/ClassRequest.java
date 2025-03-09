package com.example.CMS.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassRequest {
    private int courseID;
    private int lecturerID;
    private int adminID;
    private String day;
    private String startTime;
    private String endTime;
    private int maxStudents;
    private String status;
}
