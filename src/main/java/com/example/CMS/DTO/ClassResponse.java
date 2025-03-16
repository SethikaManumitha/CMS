package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClassResponse {
    private int classID;
    private int courseID;
    private String courseName;
    private int lecturerID;
    private String lecturerName;
    private String day;
    private String startTime;
    private String endTime;
}
