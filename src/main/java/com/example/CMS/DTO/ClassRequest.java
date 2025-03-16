package com.example.CMS.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ClassRequest {
    private int courseID;
    private int lecturerID;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private int semester;
    private String status;
}
