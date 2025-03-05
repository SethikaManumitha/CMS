package com.example.CMS.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDegreeRequest {
    private int programID;
    private int studentId;
    private int enrollmentYear;
    private String status;
    private String grade;

}
