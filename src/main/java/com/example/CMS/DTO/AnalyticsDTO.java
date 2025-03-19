package com.example.CMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticsDTO {
    private int totalStudents;
    private int totalLecturers;
    private int totalCourses;
    private int totalClassrooms;
}
