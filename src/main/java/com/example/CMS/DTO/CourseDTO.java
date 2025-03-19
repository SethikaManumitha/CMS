package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTO {
    private int courseID;
    private String courseName;
    private String status;
}
