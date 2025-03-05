package com.example.CMS.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourseRequest {
    private int courseId;
    private int studentId;
    private int marks;
    private String status;
}
